package com.test.spring.rest.test4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static com.test.spring.rest.test4.common.AppConstants.EXCEPTION_NO_HANDLER;

@ControllerAdvice
@ResponseBody
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllExceptions (Exception exception) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        int httpStatusValue = httpStatus.value();
        exceptionResponse.setCode(httpStatusValue);

        exceptionResponse.setMessage(EXCEPTION_NO_HANDLER);
        exceptionResponse.setTimestamp(LocalDateTime.now());
        exceptionResponse.setDetails(exception.getMessage() + ", " + getFirstThreeStackTraceElements(exception));

        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    //------------------------------------------------------------------------------------------------
    private String getFirstThreeStackTraceElements(Exception exception) {

        StringBuilder result = new StringBuilder();
        final StackTraceElement[] stackTraceArray = exception.getStackTrace();

        final int stackTraceItems = 3;

        for(int index = 0; index < stackTraceArray.length && index < stackTraceItems; index++) {

            result.append("[");
            result.append(stackTraceArray[index]);
            result.append("], ");
        }

        return result.toString();
    }
}
