package com.example.kunal.mockitodemo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


public class BasicUnitTest2 {

    @Mock
    Calculator mockCalculator;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {

        // specifying mock behaviour to return exception
        when(mockCalculator.div(2, 0)).thenThrow(new ArithmeticException());

        mockCalculator.div(2, 0);

    }


}
