package com.scottlogic.aaylett.iterables;

import static com.scottlogic.aaylett.iterables.CountingIterable.countingIterable;

import org.junit.Test;

import com.google.common.collect.Lists;

public class CountingIterableTest {

    @Test
    public void testTypesExist() {
        Iterable<String> it = Lists.newArrayList();
        for (Value<String> v : countingIterable(it)) {
            @SuppressWarnings("unused")
            long l = v.getCount();
            @SuppressWarnings("unused")
            String s = v.getValue();
        }
    }

}
