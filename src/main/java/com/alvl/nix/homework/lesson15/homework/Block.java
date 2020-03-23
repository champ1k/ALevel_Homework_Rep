package com.alvl.nix.homework.lesson15.homework;

@FunctionalInterface
public interface Block<T> {
     T run() throws Exception;
}
