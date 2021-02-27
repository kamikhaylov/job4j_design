package ru.job4j.block01.list.stack;

import ru.job4j.block01.list.head.ForwardLinked;

public class SimpleStack<T> {
    private ForwardLinked<T> linked;

    public SimpleStack() {
        this.linked = new ForwardLinked<T>();
    }

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }
}