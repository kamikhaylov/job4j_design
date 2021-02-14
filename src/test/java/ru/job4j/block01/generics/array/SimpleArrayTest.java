package ru.job4j.block01.generics.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class SimpleArrayTest {
    @Test
    public void addNewElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        Integer[] rsl = {simpleArray.get(0),
                         simpleArray.get(1),
                         simpleArray.get(2)};
        Integer[] expected = {0, 1, 2};
        assertThat(rsl, is(expected));
    }

    @Test
    public void getElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        simpleArray.add("a");
        simpleArray.add("b");
        simpleArray.add("c");
        assertThat(simpleArray.get(2), is("c"));
    }

    @Test
    public void removeElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.remove(0);
        simpleArray.remove(1);
        Integer[] rsl = new Integer[]{
                simpleArray.get(0),
                simpleArray.get(1),
                simpleArray.get(2),
                simpleArray.get(3),
                simpleArray.get(4)};
        Integer[] expected = {1, 3, 4, null, null};
        assertThat(rsl, is(expected));
    }

    @Test
    public void removeElementTwo() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.remove(0);
        simpleArray.remove(0);
        simpleArray.add(2);
        simpleArray.add(2);
        Integer[] rsl = new Integer[]{
                simpleArray.get(0),
                simpleArray.get(1),
                simpleArray.get(2),
                simpleArray.get(3),
                simpleArray.get(4)};
        Integer[] expected = {1, 1, 1, 2, 2};
        assertThat(rsl, is(expected));
    }

    @Test
    public void setElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.set(1, 3);
        assertThat(simpleArray.get(1), is(3));
    }

    @Test
    public void whenIterator() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        int expected = 0;
        for (Integer integer : simpleArray) {
            assertThat(integer, is(expected++));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNotIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.get(3);
    }
}