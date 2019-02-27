package com.example.kunal.mockitodemo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BasicUnitTest4 {

    @Mock
    Calculator mockCalculator;

    /**
     * We want to test clear method is invoked or not
     * <p>
     * we can test it using static method verify
     */

    @Test
    public void testMethodCallOrNot() {

        mockCalculator.clear();

        verify(mockCalculator).clear();
    }

    /**
     * we want to test weather add method is called with argument (9,11) or Not
     */
    @Test
    public void testAddMethodCallOrNot() {

        mockCalculator.add(9, 10);

        verify(mockCalculator).add(9, 11);
    }

}
