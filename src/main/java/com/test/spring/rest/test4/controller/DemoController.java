package com.test.spring.rest.test4.controller;

import com.test.spring.rest.test4.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping(value = "/sort_list_of_values", method = RequestMethod.GET)
    public ResponseEntity<Object> getArrayOrdered(@RequestParam List<Integer> firstList,
                                                  @RequestParam List<Integer> secondList) {

        //Records a log message.
        logger.info("Accepting 2 list of integers and sorting");

        //Local variables.
        List<Integer> orderedList = null;
        ResponseEntity<Object> responseEntity = null;

        //Null Check for Input.
        if (CollectionUtils.isEmpty(firstList) || CollectionUtils.isEmpty(secondList)) {

            //Defines a bad request response.
            responseEntity = new ResponseEntity(orderedList, HttpStatus.BAD_REQUEST);
        } else {

            //Call the Service to process the received data.
            orderedList = demoService.orderArrays(firstList, secondList);

            //Checks if the retrieved list is not null or empty.
            if (!CollectionUtils.isEmpty(orderedList)) {

                //Defines a response with the ordered data.
                responseEntity = new ResponseEntity<Object>(orderedList, HttpStatus.OK);
            } else {

                //Defines a internal server error response.
                responseEntity = new ResponseEntity<Object>(orderedList, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        //Returns the created response.
        return responseEntity;
    }
}
