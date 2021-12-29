package ru.job4j.block04;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return result(value, comparator, x -> x < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return result(value, comparator, x -> x > 0);
    }

    private <T> T result(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.get(0);
        for (T v : value) {
            if (predicate.test(comparator.compare(rsl, v))) {
                rsl = v;
            }
        }
        return rsl;
    }
}