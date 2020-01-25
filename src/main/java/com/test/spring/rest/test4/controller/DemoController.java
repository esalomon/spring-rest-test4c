package com.test.spring.rest.test4.controller;

import com.test.spring.rest.test4.exceptions.ParameterListException;
import com.test.spring.rest.test4.exceptions.ProcessingListException;
import com.test.spring.rest.test4.service.CommonService;
import com.test.spring.rest.test4.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.test.spring.rest.test4.common.AppConstants.*;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    CommonService commonService;
    DemoService demoService;

    @Autowired
    public DemoController(CommonService commonService,
                          DemoService demoService) {

        this.commonService = commonService;
        this.demoService = demoService;
    }

    /**
     * Receives two lists and then it merges into one list, then it orders the resulting list
     * using a reverseOrder criteria. Note, if the first or second list are null or empty the
     * controller throws an 404 response.
     * @param firstList references the first list.
     * @param secondList references the second list.
     * @return the merging result of first and second list ordered as reversedOrder.
     * @throws ProcessingListException if there is any issue processing the list.
     */
    @GetMapping(ORDER_LIST_V1)
    public ResponseEntity<List<Integer>> getArrayOrdered(@RequestParam(required = false)
                                                         List<Integer> firstList,
                                                         @RequestParam(required = false)
                                                         List<Integer> secondList) {

        //Records a log message.
        logger.info("Accepting 2 list of integers and sorting");

        //Checks if the retrieved list is not null or empty.
        if (CollectionUtils.isEmpty(firstList) || CollectionUtils.isEmpty(secondList) ) {

            //Records a log message.
            logger.error(PARAMETER_LIST_EMPTY_OR_NULL);

            //Defines a internal server error response.
            throw new ParameterListException(PARAMETER_LIST_EMPTY_OR_NULL);
        }

        //Call the Service to process the received data.
        List<Integer> orderedList = demoService.orderArrays(firstList, secondList);

        //Checks if the retrieved list is not null or empty.
        if (CollectionUtils.isEmpty(orderedList)) {

            //Throws and logs an error message.
            commonService.throwProcessingListException(logger, INTERNAL_SERVICE_ERROR);
        }

        //Returns the created response.
        return new ResponseEntity<>(orderedList, HttpStatus.OK);
    }
}
