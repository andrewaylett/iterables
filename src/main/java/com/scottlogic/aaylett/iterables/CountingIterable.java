package com.scottlogic.aaylett.iterables;


public class CountingIterable<T> implements Iterable<Value<T>> {

    private final Iterable<T> iterable;

    public CountingIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public CountingIterator<T> iterator() {
        return new CountingIterator<>(iterable.iterator());
    }

}
