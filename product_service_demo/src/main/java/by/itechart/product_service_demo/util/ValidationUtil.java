package by.itechart.product_service_demo.util;

import java.util.Arrays;

import static org.springframework.util.Assert.notNull;

public class ValidationUtil {


    public static <T> void validateParams(T ... params) {

        Arrays.stream(params)
                .forEach(param ->
                                notNull(param, "Param must be not null"));
    }
}
