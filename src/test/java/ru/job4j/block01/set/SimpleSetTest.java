package ru.job4j.block01.set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSetTest {
    @Test
    public void whenAddThenIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(0);
        simpleSet.add(1);
        simpleSet.add(2);
        Iterator<Integer> iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenAddDuplicateThenIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(0);
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        Iterator<Integer> iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        Iterator<String> iterator = simpleSet.iterator();
        iterator.next();
    }
}