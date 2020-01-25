package com.test.spring.rest.test4.common;

/**
 * Created by efrain.salomon on 1/9/2020.
 */
public class AppConstants {

    public static final String VERSION1 = "/v1";
    public static final String ORDER_LIST_V1 = VERSION1 + "/sort_list_of_values";

    public static final String PARAMETER_LIST_EMPTY_OR_NULL = "The first or second list parameters were null or empty.";
    public static final String INTERNAL_SERVICE_ERROR = "The list returned by the service was null or empty.";

    public static final String PROCESSING_LIST_ERROR = "There was an error processing the lists of integers, ";

    public static final String EXCEPTION_NO_HANDLER = "There was no custom handler for the current exception.";

    private AppConstants(){
        //this constructor was left empty.
    }
}
