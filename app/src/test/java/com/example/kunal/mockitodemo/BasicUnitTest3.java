package com.example.kunal.mockitodemo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasicUnitTest3 {

    @Mock
    Rectangle mockRectangle;

    @Mock
    CarInterface carInterface;

    @Test
    public void testAreaMethod() {

        // specifying behaviour for mock object
        when(mockRectangle.getLength()).thenReturn(10);
        when(mockRectangle.getBreadth()).thenReturn(5);

        // want to test areaCalculator.area() method
        AreaCalculator areaCalculator = new AreaCalculator();


        when(carInterface.drive()).thenReturn("120 kmps");

        assertEquals(carInterface.drive(),"120 kmps");


        // assert
//        assertEquals(50, areaCalculator.area(mockRectangle));

    }
}
