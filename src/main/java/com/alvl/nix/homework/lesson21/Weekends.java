package com.alvl.nix.homework.lesson21;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Weekends {
    private int weekdays = 0;
    int countWeekDays(LocalDate startDate, LocalDate endDate) {
        if (startDate.isEqual(endDate)) {
            return weekdays;
        }
        LocalDate checkDay = startDate;
        while (checkDay.isBefore(endDate)) {
            if (DayOfWeek.SATURDAY.equals(checkDay.getDayOfWeek())
                    || DayOfWeek.SUNDAY.equals(checkDay.getDayOfWeek())) {
                weekdays++;
            }
            checkDay = checkDay.plusDays(1);
        }
        return weekdays;
    }
}
