package ru.job4j.block01.set;

import ru.job4j.block01.list.dynamic.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArrayList<T> array;

    public SimpleSet() {
        this.array = new SimpleArrayList<>();
    }
    
    public void add(T model) {
        boolean duplicate = false;
        for (T t : array) {
            if (model.equals(t)) {
                duplicate = true;
                break;
            }
        }
        if (!duplicate) {
            array.add(model);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
