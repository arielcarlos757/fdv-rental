package com.fdv.rental.bike.core.utils;

import java.util.List;

import com.fdv.rental.bike.core.calculator.CalculatorPrice;

public class ValidateUtils {


    public static <T> void checkNotNull(T t, String message) {
        if(t == null)
        	throw new NullPointerException(message); 
    }
 
    public static <T> void checkIsEmpty(List<CalculatorPrice> t, String message) {
        if(t.isEmpty())
        	throw new RuntimeException(message); 
    }
 
    
    public static void checkIfFalse(boolean condition, String message) {
    	if(!condition)
    		throw new RuntimeException(message);
    }
}
