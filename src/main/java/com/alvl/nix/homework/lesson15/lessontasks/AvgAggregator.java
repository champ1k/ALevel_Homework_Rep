package com.alvl.nix.homework.lesson15.lessontasks;

public class AvgAggregator<T extends Number> implements Aggregator<Double, T> {
    @Override
    public Double aggregate(T... items) {
        double sum = 0, result = 0;
        if (items == null) {
            throw new IllegalArgumentException("No such array!");
        }
        if (items.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }
        for (Number item : items) {
            sum += item.doubleValue();
        }
        result = sum / items.length;
        return result;
    }
}
