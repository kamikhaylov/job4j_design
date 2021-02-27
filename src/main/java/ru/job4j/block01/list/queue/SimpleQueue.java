package ru.job4j.block01.list.queue;

import ru.job4j.block01.list.stack.SimpleStack;

public class SimpleQueue<T> {
    private final SimpleStack<T> in;
    private final SimpleStack<T> out;
    private int size;

    public SimpleQueue() {
        this.in = new SimpleStack<>();
        this.out = new SimpleStack<>();
        this.size = 0;
    }

    public T poll() {
        for (int i = 0; i < size; i++) {
            out.push(in.pop());
        }
        size--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}