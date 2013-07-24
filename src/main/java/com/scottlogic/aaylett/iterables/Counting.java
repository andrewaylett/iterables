package com.scottlogic.aaylett.iterables;

import java.util.Iterator;

public final class Counting {
    private Counting() {
        // Deliberately Blank
    }

    public static <T> CountingIterable<T> counting(Iterable<T> iterable) {
        return new CountingIterable<>(iterable);
    }

    public static <T> CountingIterator<T> counting(Iterator<T> iterator) {
        return new CountingIterator<>(iterator);
    }
}
