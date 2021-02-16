package ru.job4j.block01.generics.store;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexById(id);
        boolean result = false;
        if (index != -1) {
            mem.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexById(id);
        boolean result = false;
        if (index != -1) {
            mem.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        int index = findIndexById(id);
        return index != -1 ? mem.get(index) : null;
    }

    private int findIndexById(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (id.equals(mem.get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }
}
