package com.java_8_training.problems.datetime;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class BirthdayDiary {

    private Map<String, LocalDate> birthdays;

    public BirthdayDiary() {
        birthdays = new HashMap<>();
    }

    public LocalDate addBirthday(String name, int day, int month, int year) {
        birthdays.putIfAbsent(name, LocalDate.of(year, month, day));
        return birthdays.get(name);
    }

    public LocalDate getBirthdayFor(String name) {
        return birthdays.get(name);
    }

    public int getAgeInYear(String name, int year) {
        return Period.between(birthdays.get(name), LocalDate.of(year, Month.DECEMBER, 31)).getYears();
    }

    public Set<String> getFriendsOfAgeIn(int age, int year) {
        return birthdays.keySet().stream()
            .filter((name) -> getAgeInYear(name, year) == age)
            .collect(toSet());
    }

    public Set<String> getBirthdaysIn(Month month) {
        return birthdays.keySet().stream()
            .filter((name) -> birthdays.get(name).getMonth() == month)
            .collect(toSet());
    }

    public int getTotalAgeInYears() {
        return birthdays.keySet().stream()
            .mapToInt((name) -> getAgeInYear(name, LocalDate.now().getYear()))
            .sum();
    }
}
