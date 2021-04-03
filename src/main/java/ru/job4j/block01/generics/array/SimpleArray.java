package ru.job4j.block01.generics.array;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int size;
    private int indexArray = 0;

    @SuppressWarnings("unchecked")
    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
    }

    public void add(T model) {
        array[indexArray++] = model;
    }

    public void set(int index, T model) {
        checkIndex(index);
        array[index] = model;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        array[array.length - 1] = null;
        indexArray--;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < indexArray;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[point++];
            }
        };
        return it;
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, indexArray);
    }
}