package ru.job4j.block04.srp.report;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
