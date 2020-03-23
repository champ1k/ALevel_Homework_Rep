package com.alvl.nix.homework.lesson15.lessontasks;

public interface Aggregator<A, T> {
    A aggregate(T[] items);
}

