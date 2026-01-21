package net.oussama.micordemo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName,String fielName,String fieldValue) {
        super(String.format("Resource %s not found with name %s and value %s", resourceName, fielName, fieldValue));
    }
}
