package com.test.spring.rest.test4.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
public class ArrayModel {

    private List<Integer> arrayOne;
    private List<Integer> arrayTwo;
}
