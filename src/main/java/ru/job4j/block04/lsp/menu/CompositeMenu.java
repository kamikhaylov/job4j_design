package ru.job4j.block04.lsp.menu;

import java.util.ArrayList;
import java.util.List;

public class CompositeMenu implements Menu {
    private String name;
    private List<Menu> menu;
    private int printLevel;

    public CompositeMenu() {
        this.menu = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String output() {
        String result = new String();
        for (Menu m : menu) {
            result += m.output();
        }
        return result;
    }

    public void addComponent(Menu component) {
        menu.add(component);
    }
}