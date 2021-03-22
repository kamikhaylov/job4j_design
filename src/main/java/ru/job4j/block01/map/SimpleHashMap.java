package ru.job4j.block01.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<K> {
    private Node<K, V>[] table;
    private int size;
    private int n;
    private float loadFactor;
    private int modCount;

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + hash + " " + key + " " + value + "";
        }
    }

    public SimpleHashMap() {
        this.n = 16;
        this.table = new Node[n];
        this.size = 0;
        this.loadFactor = 0.75f;
        this.modCount = 0;
    }

    private final int hash(Object key) {
        int h = key.hashCode();
        return (n - 1) & (h ^ (h >>> 16));
    }

    public boolean insert(K key, V value) {
        int hash = hash(key);
        int i = (n - 1) & hash;
        if (checkIndexNode(i)) {
            checkSizeTable();
            table[i] = new Node<>(hash, key, value);
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        int hash = hash(key);
        int i = (n - 1) & hash;
        return checkIndexNode(i) ? null : table[i].value;
    }

    public boolean delete(K key) {
        int hash = hash(key);
        int i = (n - 1) & hash;
        if (!checkIndexNode(i) && Objects.equals(key, table[i].key)) {
            table[i] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    private boolean checkIndexNode(int index) {
        return table[index] == null ? true : false;
    }

    private void checkSizeTable() {
        if (size >= loadFactor * table.length) {
            table = grow();
        }
    }

    private Node<K, V>[] grow() {
        Node<K, V>[] newTable = new Node[n *= 2];
        int i = 0;
        for (Node<K, V> t : table) {
            newTable[i++] = t;
        }
        return newTable;
    }

    @Override
    public Iterator<K> iterator() {
        Iterator<K> it = new Iterator<K>() {
            private int point = 0;
            private int temp = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = temp; i < table.length; i++) {
                    if (table[i] != null) {
                        temp = i;
                        temp++;
                        point++;
                        return table[i].key;
                    }
                }
                return null;
            }
        };
        return it;
    }
}
