package com.example.kunal.mockitodemo;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BasicUnitTest {

    /**
     * Very basic test to check calculator add method
     */
    @Test
    public void testAddition(){

        Calculator calculator = new Calculator();

        assertEquals(10,calculator.add(3,7));

    }

    @Test
    public void testAdditionWithMockito(){

        Calculator mockCalculator = Mockito.mock(Calculator.class);

        when(mockCalculator.add(3,7)).thenReturn(10);

        assertEquals(10,mockCalculator.add(3,7));

    }
}
