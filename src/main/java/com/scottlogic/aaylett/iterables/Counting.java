package com.scottlogic.aaylett.iterables;

import java.util.Iterator;

public final class Counting {
    private Counting() {
        // Deliberately Blank
    }

    public static <T> Iterable<Counted<T>> counting(Iterable<T> iterable) {
        return new CountingIterable<>(iterable);
    }

    public static <T> Iterator<Counted<T>> counting(Iterator<T> iterator) {
        return new CountingIterator<>(iterator);
    }
}
