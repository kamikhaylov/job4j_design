package ru.job4j.block01.list.dynamic;

import java.util.*;

public class SimpleLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;
    private int modCount;

    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public SimpleLinkedList() {
        this.size = 0;
        this.modCount = 0;
    }

    public void add(T value) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.item;
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, size);
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private Node<T> point = first;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element = point.item;
                point = point.next;
                return element;
            }
        };
        return it;
    }
}