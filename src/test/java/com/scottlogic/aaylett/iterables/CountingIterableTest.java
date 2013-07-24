package com.scottlogic.aaylett.iterables;

import static com.google.common.collect.Lists.newArrayList;
import static com.scottlogic.aaylett.iterables.CountingIterable.countingIterable;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountingIterableTest {

    @Test
    public void testTypesExist() {
        Iterable<String> it = newArrayList();
        for (Value<String> v : countingIterable(it)) {
            @SuppressWarnings("unused")
            long l = v.getCount();
            @SuppressWarnings("unused")
            String s = v.getValue();
        }
    }

    @Test
    public void testNumbersReturnedInSequence() {
        List<Integer> list = newNumberList();
        int i = 0;
        for (Value<Integer> v : countingIterable(list)) {
            assertTrue("Iteration Count", v.getCount() == i++);
        }
        assertTrue("Total number of iterations", i == list.size());
    }

    @Test
    public void testObjectsReturnedInSequence() {
        List<Integer> list = newNumberList();
        int i = 0;
        for (Value<Integer> v : countingIterable(list)) {
            assertTrue("Iteration Value", v.getValue() == list.get(i++));
        }
        assertTrue("Total number of iterations", i == list.size());
    }

    private ArrayList<Integer> newNumberList() {
        return newArrayList(1,2,3,4,5,6,7,8,9,10);
    }

}
