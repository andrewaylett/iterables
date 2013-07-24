package com.scottlogic.aaylett.iterables;

import java.util.Iterator;

public final class CountingIterator<T> implements Iterator<Value<T>> {
    private final Iterator<T> it;
    long count = 0;

    public CountingIterator(Iterator<T> it) {
        this.it = it;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Value<T> next() {
        final long currentCount = count++;
        final T currentValue = it.next();
        return new Value<T>() {

            @Override
            public long getCount() {
                return currentCount;
            }

            @Override
            public T getValue() {
                return currentValue;
            }

        };
    }

    @Override
    public void remove() {
        it.remove();
    }
}