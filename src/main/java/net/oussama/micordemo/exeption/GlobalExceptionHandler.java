package net.oussama.micordemo.exeption;

import net.oussama.micordemo.dtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
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
