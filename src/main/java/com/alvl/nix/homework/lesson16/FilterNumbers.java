package com.alvl.nix.homework.lesson16;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FilterNumbers {


    public static long parse(Collection<String> strings) {
        return strings.stream()
                .flatMapToInt(string -> string.codePoints())
                .filter(codePoint -> Character.isDigit(codePoint))
                .map(codepoint -> {
                    return Character.digit(codepoint, 10);
                })
                .asLongStream()
                .reduce((result, next) -> {
                    return result * 10 + next;
                })
                .orElseThrow(() -> new IllegalArgumentException("No digits found in " + strings));
    }
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("string 1 text", "2 string 3 text", "45");
        System.out.println(strings + ": " + parse(strings));
    }
}
