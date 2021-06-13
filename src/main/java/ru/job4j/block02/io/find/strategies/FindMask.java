package ru.job4j.block02.io.find.strategies;

import java.nio.file.Path;
import java.util.function.Predicate;

public class FindMask implements FindStrategy {
    @Override
    public Predicate<Path> getPredicate(String name) {
        String nameFind = name
                .replace("*", ".+")
                .replace("?", ".{1}");
        return new FindRegex().getPredicate(nameFind);
    }
}