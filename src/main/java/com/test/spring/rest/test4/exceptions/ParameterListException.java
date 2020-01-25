package com.test.spring.rest.test4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParameterListException extends RuntimeException {

    public ParameterListException(String errorMessage) {
        super(errorMessage);
    }
}
