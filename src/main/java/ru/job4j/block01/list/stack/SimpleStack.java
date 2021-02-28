package ru.job4j.block01.list.stack;

import ru.job4j.block01.list.head.ForwardLinked;

public class SimpleStack<T> {
    private ForwardLinked<T> linked;
    private int size;

    public SimpleStack() {
        this.linked = new ForwardLinked<T>();
        this.size = 0;
    }

    public T pop() {
        size--;
        return linked.deleteFirst();
    }

    public void push(T value) {
        size++;
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        return size == 0;
    }
}