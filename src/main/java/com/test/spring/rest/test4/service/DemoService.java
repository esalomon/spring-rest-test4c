package com.test.spring.rest.test4.service;

import com.test.spring.rest.test4.exceptions.ProcessingListException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.test.spring.rest.test4.common.AppConstants.INTERNAL_SERVICE_ERROR;
import static com.test.spring.rest.test4.common.AppConstants.PROCESSING_LIST_ERROR;

@Service
public class DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    CommonService commonService;

    @Autowired
    public DemoService(CommonService commonService) {

        this.commonService = commonService;
    }

    public List<Integer> orderArrays(List<Integer> firstList, List<Integer> secondList) {

        //Records a log message.
        logger.debug("START :: Service Method Starts");

        //Local variable.
        List<Integer> orderedList = null;

        try {

            //Stores the second list inside the first one.
            firstList.addAll(secondList);

            //Removes the duplicates and orders the list of integers.
            orderedList = firstList.stream()
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

        } catch (Exception exception) {

            //Defines the error message.
            String errorMessage = PROCESSING_LIST_ERROR + exception.getMessage();

            //Throws and logs an error message.
            commonService.throwProcessingListException(logger, errorMessage);
        }

        //Records a log message.
        logger.debug("END :: Service Method Starts");

        //Reverse order using streams.
        return orderedList;
    }
}
