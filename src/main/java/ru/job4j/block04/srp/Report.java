package ru.job4j.block04.srp;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
