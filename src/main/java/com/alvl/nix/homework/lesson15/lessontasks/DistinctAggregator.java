package com.alvl.nix.homework.lesson15.lessontasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DistinctAggregator<T> implements Aggregator<Integer, T> {
    @Override
    public Integer aggregate(T[] items) {
        Set<T> distinct = new HashSet<>(Arrays.asList(items));

        //distinct.addAll(Arrays.asList(items));

        /*for (T item : items) {
            distinct.add(item);
        }
        */
        return distinct.size();
    }
}
