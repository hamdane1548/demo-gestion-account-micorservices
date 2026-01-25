package net.oussama.loans.Exeption;

import net.oussama.loans.Dto.ErrorResponseDto;
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

import javax.smartcardio.CardException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ControllerAdvice
public class GlobalExecption extends ResponseEntityExceptionHandler {
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        Map<String,String> errors = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        allErrors.forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            String fielderror = ((FieldError) error).getField();
            errors.put(fielderror,errorMessage);
        });
        return new ResponseEntity<>(errors, status);
    }
    @ExceptionHandler(LoansAleradyExists.class)
    public ResponseEntity<ErrorResponseDto> handleCardException(CardException ex, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        System.out.println(errorResponseDto);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handlExceptions(Exception ex, WebRequest request){
        return new ResponseEntity<>(new ErrorResponseDto(
                request.getContextPath(),
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
                ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
