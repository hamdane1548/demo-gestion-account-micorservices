package net.oussama.micordemo.exeption;

import net.oussama.micordemo.dtos.ErrorResponseDto;
import net.oussama.micordemo.dtos.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        Map<String,String> errors = new HashMap<>();
        List<ObjectError> fieldErrors = ex.getBindingResult().getAllErrors();
        fieldErrors.forEach(error->{
            String FieldName=((FieldError)error).getField();
            String defautlmessage=error.getDefaultMessage();
            errors.put(FieldName,defautlmessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleExceptionv(Exception ex, WebRequest request){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(CustomerAleradyExistExeption.class)
    public ResponseEntity<ErrorResponseDto> handlecustomeralreadyexistExepition(CustomerAleradyExistExeption exeption, WebRequest request){
        ErrorResponseDto errordto = new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exeption.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errordto, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> resrourceexception(ResourceNotFoundException exeption, WebRequest request){
        ErrorResponseDto errordto = new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.NOT_FOUND,
                exeption.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errordto, HttpStatus.NOT_FOUND);
    }
}
