package com.example.kunal.mockitodemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class BasicUnitTest2 {

    @Mock
    Calculator mockCalculator;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test(expected = ArithmeticException.class)
    public void testDivideByZero(){

        // // specifying mock behaviour to return exception
        when(mockCalculator.div(2,0)).thenThrow(new ArithmeticException());


        mockCalculator.div(2,0);

    }


}
