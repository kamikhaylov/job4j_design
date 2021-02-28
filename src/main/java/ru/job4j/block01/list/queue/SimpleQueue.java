package ru.job4j.block01.list.queue;

import ru.job4j.block01.list.stack.SimpleStack;

public class SimpleQueue<T> {
    private final SimpleStack<T> in;
    private final SimpleStack<T> out;

    public SimpleQueue() {
        this.in = new SimpleStack<>();
        this.out = new SimpleStack<>();
    }

    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}