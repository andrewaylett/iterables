package com.scottlogic.aaylett.iterables;

import java.util.Iterator;

public class CountingIterable<T> implements Iterable<Value<T>> {

    public static <U> CountingIterable<U> countingIterable(Iterable<U> it) {
        return new CountingIterable<>();
    }

    @Override
    public Iterator<Value<T>> iterator() {
        return new Iterator<Value<T>>() {

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public Value<T> next() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void remove() {
                // TODO Auto-generated method stub

            }
        };
    }

}
