package ru.job4j.block04;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Comparator;
import java.util.List;

public class MaxMinTest {
    @Test
    public void whenListThenMax() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Comparator<Integer> comparator = Integer::compareTo;
        Integer expected = 5;
        MaxMin max = new MaxMin();
        assertThat(max.max(list, comparator), is(expected));
    }

    @Test
    public void whenListThenMin() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Comparator<Integer> comparator = Integer::compareTo;
        Integer expected = 1;
        MaxMin min = new MaxMin();
        assertThat(min.min(list, comparator), is(expected));
    }
}