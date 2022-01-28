package ru.job4j.block04.lsp.menu;

public class DemoMenu {
    public static void main(String[] args) {
        CreateMenu menu = new CreateConsoleMenu();
        menu.create();
        menu.add("Задача 1.", new SimpleAction("Действие 1"));
        menu.add("Задача 1.", "Задача 1.1.", new SimpleAction("Действие 2"));
        menu.add("Задача 1.1.", "Задача 1.1.1.", new SimpleAction("Действие 3"));
        menu.add("Задача 1.1.", "Задача 1.1.2.", new SimpleAction("Действие 4"));
        menu.add("Задача 1.1.", "Задача 1.1.3.", new SimpleAction("Действие 5"));
        menu.add("Задача 1.", "Задача 1.2.", new SimpleAction("Действие 6"));
        menu.add("Задача 2.", new SimpleAction("Действие 7"));
        menu.add("Задача 2.", "Задача 2.1.", new SimpleAction("Действие 8"));
        menu.add("Задача 2.1.", "Задача 2.1.1.", new SimpleAction("Действие 9"));
        menu.add("Задача 2.1.1.", "Задача 2.1.1.1.", new SimpleAction("Действие 10"));
        menu.add("Задача 3.", new SimpleAction("Действие 11"));
        System.out.println(menu.output());
        System.out.println(menu.select("Задача 2.1.1.1.").execute());
    }
}