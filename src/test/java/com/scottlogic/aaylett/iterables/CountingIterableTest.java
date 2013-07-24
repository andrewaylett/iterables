package com.scottlogic.aaylett.iterables;

import static com.google.common.collect.Lists.newArrayList;
import static com.scottlogic.aaylett.iterables.Counting.counting;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class CountingIterableTest {

    @Test
    public void testTypesExist() {
        Iterable<String> it = newArrayList();
        for (Value<String> v : counting(it)) {
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
        for (Value<Integer> v : counting(list)) {
            assertTrue("Iteration Count", v.getCount() == i++);
        }
        assertTrue("Total number of iterations", i == list.size());
    }

    @Test
    public void testObjectsReturnedInSequence() {
        List<Integer> list = newNumberList();
        int i = 0;
        for (Value<Integer> v : counting(list)) {
            assertTrue("Iteration Value", v.getValue() == list.get(i++));
        }
        assertTrue("Total number of iterations", i == list.size());
    }

    @Test
    public void testRemoveWorks() {
        List<Integer> list = newNumberList();
        int oldSize = list.size();
        List<Integer> oldList = newArrayList(list);
        Iterator<Value<Integer>> it = counting(list.iterator());
        while (it.hasNext()) {
            Value<Integer> v = it.next();
            if (v.getCount() % 2 != 0) {
                it.remove();
            }
        }

        assertTrue("Removed the right number of objects", list.size() == oldSize/2);

        for (int i=0; i < list.size(); i++) {
            assertTrue(list.get(i).equals(oldList.get(i * 2)));
        }
    }

    private ArrayList<Integer> newNumberList() {
        return newArrayList(1,2,3,4,5,6,7,8,9,10);
    }

}
