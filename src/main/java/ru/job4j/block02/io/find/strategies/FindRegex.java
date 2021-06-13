package ru.job4j.block02.io.find.strategies;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FindRegex implements FindStrategy {
    @Override
    public Predicate<Path> getPredicate(String name) {
        Pattern pattern = Pattern.compile(name);
        return p -> pattern.matcher(p.toFile().getName()).find();
    }
}