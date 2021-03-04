package ru.job4j.block01.set;

import ru.job4j.block01.list.dynamic.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArrayList<T> array;

    public SimpleSet() {
        this.array = new SimpleArrayList<>();
    }
    
    public void add(T model) {
        if (!duplicate(model)) {
            array.add(model);
        }
    }

    public boolean duplicate(T model) {
        boolean rsl = false;
        for (T t : array) {
            if (Objects.equals(model, t)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
