package ru.job4j.block04.lsp.menu;

public interface CreateMenu {
    void create();

    String output();

    boolean add(String name, Action action);

    boolean add(String parentName, String childName, Action action);

    Action select(String itemName);
}