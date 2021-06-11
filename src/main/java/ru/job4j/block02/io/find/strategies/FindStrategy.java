package ru.job4j.block02.io.find.strategies;

import java.nio.file.Path;
import java.util.function.Predicate;

public interface FindStrategy {
    Predicate<Path> getPredicate(String name);
}