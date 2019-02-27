package com.example.kunal.mockitodemo;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BasicUnitTest {

    /**
     * Very basic test to check calculator add method without mockito
     */
    @Test
    public void testAddition(){
        Calculator calculator = new Calculator();
        assertEquals(10,calculator.add(3,7));
    }



    /**
     *                  USING MOCKITO
     *
     *             when - we specify which behaviour we want to mock
     *
     *       thenReturn - we specify what value should return
     */


    @Test
    public void testAdditionWithMockito(){

        // Create mock object of calculator class
        Calculator mockCalculator = Mockito.mock(Calculator.class);

        // specifying mock behaviour
        when(mockCalculator.add(3,7)).thenReturn(10);

        //test
        assertEquals(10,mockCalculator.add(3,7));

    }
}
