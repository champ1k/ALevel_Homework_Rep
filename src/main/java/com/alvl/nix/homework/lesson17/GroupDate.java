package com.alvl.nix.homework.lesson17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class GroupDate {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        List<LocalDateTime> timestamps = Arrays.asList(
                now,
                now.minusHours(2),
                now.plusHours(4),
                now.minusDays(3),
                now.plusDays(10),
                now.plusHours(25),
                now.plusDays(4)
        );
        System.out.println(timestamps);

        SortedMap<LocalDate, List<LocalTime>> byDate = groupByDateAscending(timestamps);
        System.out.println(byDate);

        String newline = System.lineSeparator();
        String humanReadableOutput = byDate.entrySet().stream()
                .map(String::valueOf)
                .collect(joining(newline, "Human readable output:" + newline, newline));
        System.out.print(humanReadableOutput);
    }

    public static SortedMap<LocalDate, List<LocalTime>> groupByDateAscending(Collection<LocalDateTime> timestamps) {

        return timestamps.stream().collect(Collectors.groupingBy(
                LocalDateTime::toLocalDate,
                TreeMap::new,
                Collectors.mapping(LocalDateTime::toLocalTime, Collectors.toList())
        ));
    }
}

