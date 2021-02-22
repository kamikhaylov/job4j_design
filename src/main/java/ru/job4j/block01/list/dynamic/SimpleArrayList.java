package ru.job4j.block01.list.dynamic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements Iterable<T> {
    private T[] container;
    private int size;
    private int indexContainer;
    private int modCount;

    public SimpleArrayList() {
        this.size = 10;
        this.modCount = 0;
        this.indexContainer = 0;
        this.container = (T[]) new Object[size];
    }

    public T get(int index) {
        checkIndex(index);
        return container[index];
    }

    public void add(T model) {
        container[indexContainer++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < indexContainer;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[point++];
            }
        };
        return it;
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, indexContainer);
    }
}