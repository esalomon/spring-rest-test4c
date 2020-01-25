package com.test.spring.rest.test4.exceptions;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Created by efrain.salomon on 1/9/2020.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExceptionResponse {

    private int code;
    private String message;
    private LocalDateTime timestamp;
    private String details;
}
