package com.example.kunal.mockitodemo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BasicUnitTest4 {

    @Mock
    Calculator mockCalculator;

    @Before
    public void setup(){
        doNothing().when(mockCalculator).clear();
    }


    /**
     *   We want to test clear method is invoked or not
     *
     *   we can test it using static method verify
     */

    @Test
    public void testMethodCallOrNot(){

        mockCalculator.clear();

        verify(mockCalculator).clear();
    }

}
