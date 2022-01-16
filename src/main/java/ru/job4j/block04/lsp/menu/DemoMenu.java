package ru.job4j.block04.lsp.menu;

public class DemoMenu {
    public static void main(String[] args) {
        ConsoleMenu menu1 = new ConsoleMenu("Задача 1.");
        ConsoleMenu menu11 = new ConsoleMenu("Задача 1.1.");
        ConsoleMenu menu12 = new ConsoleMenu("Задача 1.2.");
        ConsoleMenu menu121 = new ConsoleMenu("Задача 1.2.1.");
        ConsoleMenu menu122 = new ConsoleMenu("Задача 1.2.2.", new SimpleAction("Пример"));
        ConsoleMenu menu2 = new ConsoleMenu("Задача 2.");
        CompositeMenu compositeMenu = new CompositeMenu();
        CompositeMenu compositeMenu1 = new CompositeMenu();
        CompositeMenu compositeMenu2 = new CompositeMenu();
        CompositeMenu compositeMenu3 = new CompositeMenu();
        CompositeMenu compositeMenu4 = new CompositeMenu();
        CompositeMenu compositeMenu5 = new CompositeMenu();
        compositeMenu5.addComponent(menu121);
        compositeMenu5.addComponent(menu122);
        compositeMenu4.addComponent(menu12);
        compositeMenu4.addComponent(compositeMenu5);
        compositeMenu3.addComponent(menu11);
        compositeMenu3.addComponent(compositeMenu4);
        compositeMenu2.addComponent(menu1);
        compositeMenu2.addComponent(compositeMenu3);
        compositeMenu1.addComponent(compositeMenu2);
        compositeMenu1.addComponent(menu2);

        System.out.println(compositeMenu1.output());
        menu122.execute();
    }
}