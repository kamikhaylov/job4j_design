package ru.job4j.block01.list.dynamic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListTest {

    @Test
    public void whenAddThenGet() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
        assertThat(simpleLinkedList.get(1), is(2));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        Iterator<Integer> iterator = simpleLinkedList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        Iterator<Integer> iterator = simpleLinkedList.iterator();
        simpleLinkedList.add(3);
        assertThat(iterator.hasNext(), is(true));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.get(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();
        Iterator<String> iterator = simpleLinkedList.iterator();
        iterator.next();
    }
}