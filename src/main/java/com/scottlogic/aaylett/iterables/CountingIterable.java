package com.scottlogic.aaylett.iterables;

import java.util.Iterator;

public class CountingIterable<T> implements Iterable<Value<T>> {

    public static <U> CountingIterable<U> countingIterable(Iterable<U> it) {
        return new CountingIterable<>(it);
    }

    private final Iterable<T> iterable;

    private CountingIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<Value<T>> iterator() {
        final Iterator<T> it = iterable.iterator();
        return new Iterator<Value<T>>() {
            long count = 0;

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
        };
    }

}
