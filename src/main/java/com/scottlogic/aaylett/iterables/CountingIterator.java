package com.scottlogic.aaylett.iterables;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;

public final class CountingIterator<T> implements Iterator<Counted<T>> {
    private final Iterator<T> it;
    private long count = 0;

    public CountingIterator(Iterator<T> it) {
        this.it = checkNotNull(it);
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Counted<T> next() {
        final long currentCount = count++;
        final T currentValue = it.next();

        return new Counted<T>() {
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