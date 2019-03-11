package com.example.kunal.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasicUnitTest9_spy_diff {

// ------------------------ mock
    @Test
    public void whenCreateMock_thenCreated() {

        // create mock object
        List mockedList = Mockito.mock(ArrayList.class);

        mockedList.add("one");
        mockedList.add("two");
        Mockito.verify(mockedList).add("one");
        Mockito.verify(mockedList).add("two");

//        when(mockedList.size()).thenReturn(500);

        assertEquals(0, mockedList.size());
    }


// ------------------------ spy
    @Test
    public void whenCreateSpy_thenCreate() {

        // create spy object
        List spyList = Mockito.spy(new ArrayList());

        spyList.add("one");
        spyList.add("two");
        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());
    }
}
