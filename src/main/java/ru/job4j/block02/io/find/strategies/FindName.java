package ru.job4j.block02.io.find.strategies;

import java.nio.file.Path;
import java.util.function.Predicate;

public class FindName implements FindStrategy {
    @Override
    public Predicate<Path> getPredicate(String name) {
        return p -> p.toFile().getName().equals(name);
    }
}