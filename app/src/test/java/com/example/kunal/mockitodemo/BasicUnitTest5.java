package com.example.kunal.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasicUnitTest5 {

    @Mock
    AreaCalculator mockAreaCalculator;

    @Mock
    Calculator mockCalculator;

    /**
     *      Matcher :
     *      Matchers are like regex or wildcards where instead of a specific input (and or output),
     *      you specify a range/type of input/output based on which methods calls can be verified.
     *
     *
     *      There are mainly 2 types of matchers in Mockito
     *
     *      1.  Argument Matchers
     *      2.  Verification Matchers
     *
     *      For both types of Matchers i.e. Argument and Verification, Mockito provides a huge set of matchers
     *      https://static.javadoc.io/org.mockito/mockito-core/1.10.19/org/mockito/Matchers.html
     *
     *      Listed down are the most widely used ones
     */


    /**
     * 1.  Argument Matchers
     */

    // 1.   any() – Accepts any object (including null).
    @Test
    public void testAdditionUsingAnyMatcher1() {

        when(mockCalculator.multi(any(), any())).thenReturn(7);

//        assertEquals(40,mockCalculator.multi(2,20));    // fail
        assertEquals(7, mockCalculator.multi(2, 20));

    }

    // 2.   any(java language class)
    @Test
    public void testAdditionUsingAnyMatcher2() {

        when(mockAreaCalculator.area(any(Rectangle.class))).thenReturn(500);

        Rectangle rectangle = new Rectangle(2, 2);

        assertEquals(500, mockAreaCalculator.area(rectangle));

    }

    // 3.   anyBoolean(), anyByte(), anyInt(), anyString(), anyDouble(), anyFloat(), anyList()
    @Test
    public void testAdditionUsingAnyMatcher3() {

        when(mockCalculator.add(anyInt(), anyInt())).thenReturn(7);

        assertEquals(7, mockCalculator.add(500, 500));

    }


    /**
     * 2.  Verification Matchers
     * <p>
     * There are some specialized matchers that are available to expect/assert things
     * like numbers of invocations on the mock.
     */


    // 1. Simple invocation on Mock verifies whether the mocked method was called or not
    @Test
    public void testClearMethodCallOrNot() {

        mockCalculator.clear();

        verify(mockCalculator).clear();
    }


    // 2. Specific count of interactions
    @Test
    public void testMethodCallCount() {

        mockCalculator.clear();
        mockCalculator.clear();
        mockCalculator.clear();

        verify(mockCalculator, times(3)).clear();
    }

    // 3. no interactions
    @Test
    public void testMethodNeverCall() {

//        mockCalculator.clear();

        verify(mockCalculator, never()).clear();
    }

    // 4. Verify the order of mocked interactions
    @Test
    public void testMethodOrderCall() {

        InOrder mockInvocationSequence = Mockito.inOrder(mockCalculator);

        mockCalculator.clear();
        mockCalculator.clearMemory();
        mockCalculator.add(2, 2);

        mockInvocationSequence.verify(mockCalculator).clear();
        mockInvocationSequence.verify(mockCalculator).clearMemory();
        mockInvocationSequence.verify(mockCalculator).add(anyInt(), anyInt());

    }

    //  5. atleast(3) – Verifies that the mocked object was invoked/interacted with atleast thrice
    //    verify(mockCalculator,atLeast(3)).clear();

    //  6. atmost(2) – verifies if the mocked object got invoked/interacted with atmost twice
    //    verify(mockCalculator,atmost(2)).clear();

}
