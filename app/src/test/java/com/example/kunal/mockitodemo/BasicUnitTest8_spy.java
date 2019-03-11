package com.example.kunal.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BasicUnitTest8_spy {


    @Test
    public void basicSpyTest() {

        List<String> list = new ArrayList<String>();
        list.add("one");
        List<String> spyList = Mockito.spy(list);

        assertEquals(1, spyList.size());

    }



    @Test
    public void basicSpyListTest() {

        List<String> list = new ArrayList<String>();
        list.add("Hi");
        List<String> spyList = Mockito.spy(list);


        Mockito.when(spyList.size()).thenReturn(100);

        assertEquals(100, spyList.size());
    }

}
