package com.test.spring.rest.test4.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    public List<Integer> orderArrays(List<Integer> firstList, List<Integer> secondList) {

        //Records a log message.
        logger.debug("START :: Service Method Starts");

        //Local variable.
        List<Integer> orderedList = null;

        try {

            //Stores the second list inside the first one.
            firstList.addAll(secondList);

            //Removes the duplicates and orders the list of integers.
            orderedList = firstList.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        } catch (Exception exception) {

            //Records a log message.
            logger.error("There was an error processing the lists of integers, " + exception.getMessage());
        }

        //Records a log message.
        logger.debug("END :: Service Method Starts");

        //Reverse order using streams.
        return orderedList;
    }
}
