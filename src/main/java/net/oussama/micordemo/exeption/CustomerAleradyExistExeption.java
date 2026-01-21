package net.oussama.micordemo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomerAleradyExistExeption extends RuntimeException {
    public CustomerAleradyExistExeption(String message) {
        super(message);
    }
}
