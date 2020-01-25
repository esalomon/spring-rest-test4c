package com.test.spring.rest.test4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ProcessingListException extends RuntimeException {

    public ProcessingListException(String errorMessage) {
        super(errorMessage);
    }
}
