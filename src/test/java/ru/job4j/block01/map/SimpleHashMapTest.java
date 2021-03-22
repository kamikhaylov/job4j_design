package ru.job4j.block01.map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class SimpleHashMapTest {
    @Test
    public void addNewElementAndGetElement() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(0, "a0");
        map.insert(1, "a1");
        map.insert(2, "a2");
        String[] rsl = {map.get(0),
                        map.get(1),
                        map.get(2)};
        String[] expected = {"a0", "a1", "a2"};
        assertThat(rsl, is(expected));
    }

    @Test
    public void deleteElement() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        for (int i = 0; i < 20; i++) {
            map.insert(i, "a" + i);
        }
        map.delete(15);
        String[] rsl = {map.get(14),
                        map.get(15),
                        map.get(16)};
        String[] expected = {"a14", null, "a16"};
        assertThat(rsl, is(expected));
    }
}