package net.oussama.cards.Exeption;

import net.oussama.cards.Dto.ErrorDto;
import net.oussama.cards.Dto.ResponseDto;
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
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ControllerAdvice
public class GlobalExeption extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        Map<String,String> errors = new HashMap<>();
        List<ObjectError> objectError = ex.getBindingResult().getAllErrors();
        objectError.forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            String FieldErrr=((FieldError) error).getField();
            errors.put(FieldErrr,errorMessage);
        });
        return new  ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handlExceptions(Exception ex, WebRequest request){
        return new ResponseEntity<>(new ErrorDto(
                request.getContextPath(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage()
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(CardAlerdayExistsExption.class)
    public ResponseEntity<ErrorDto> cardsAleradyExists(CardAlerdayExistsExption exption,WebRequest request){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(
                  request.getContextPath(),
                  LocalDateTime.now(),
                  HttpStatus.BAD_REQUEST,
                  exption.getMessage()
          ));
    }
}
