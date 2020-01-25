package com.test.spring.rest.test4.service;

import com.test.spring.rest.test4.exceptions.ProcessingListException;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    public void throwProcessingListException(Logger logger, String errorMessage) {

        //Records a log message.
        logger.error(errorMessage);

        //Defines a internal server error response.
        throw new ProcessingListException(errorMessage);
    }
}
