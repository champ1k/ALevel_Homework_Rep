package com.alvl.nix.homework.lesson15.lessontasks;

import java.util.StringJoiner;

public class CSVAggregator<T> implements Aggregator<String, T> {
    @Override
    public String aggregate(T... items) {
        StringBuilder concatItems = null;
        if (items == null) {
            throw new IllegalArgumentException("No such array!");
        }
        if (items.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }
        for (T item : items) {
            concatItems.append(item);
        }
        StringJoiner joiner = new StringJoiner(",");
        for (T item : items) {
            joiner.add(String.valueOf(item));
        }
        String finall = joiner.toString();
        return finall;
    }
}
