package net.oussama.loans.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
    private String PathApi;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
