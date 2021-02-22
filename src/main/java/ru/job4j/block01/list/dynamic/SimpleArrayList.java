package ru.job4j.block01.list.dynamic;

import java.util.*;

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

    public int getSize() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        return container[index];
    }

    public void add(T model) {
        if (indexContainer == container.length) {
            container = grow();
        }
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

    private T[] grow() {
        size = container.length * 2;
        return Arrays.copyOf(container, size);
    }
}