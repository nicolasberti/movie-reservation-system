package com.movies.demo.models.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidRequestException extends RuntimeException {
    private int status = 404;
    public InvalidRequestException(String message, int status) {
        super(message);
        this.status = status;
    }
    public InvalidRequestException(String message) {
        super(message);
    }
    
}
