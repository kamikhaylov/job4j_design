package ru.job4j.block04.lsp.menu;

import java.util.ArrayList;
import java.util.List;

public class CreateConsoleMenu implements CreateMenu {
    private List<ConsoleMenu> menu;

    @Override
    public void create() {
        menu = new ArrayList<>();
    }

    @Override
    public String output() {
        String rsl = new String();
        for (ConsoleMenu consoleMenu : menu) {
            rsl += consoleMenu.getName() + System.lineSeparator();
            if (!consoleMenu.getChilds().isEmpty()) {
                rsl += consoleMenu.outputChilds(0);
            }
        }
        return rsl;
    }

    public boolean add(String name, Action action) {
        return menu.add(new ConsoleMenu(name, action));
    }

    public boolean add(String parentName, String childName, Action action) {
        boolean rsl = false;
        for (ConsoleMenu consoleMenu : menu) {
            if (parentName.equals(consoleMenu.getName())) {
                rsl = consoleMenu.getChilds().add(new ConsoleMenu(childName, action));
            } else {
                rsl = consoleMenu.addChild(parentName, childName, action);
            }
        }
        return rsl;
    }

    @Override
    public Action select(String itemName) {
        Action rsl = new SimpleAction("Нет действия");
        for (ConsoleMenu consoleMenu : menu) {
            if (itemName.equals(consoleMenu.getName())) {
               return consoleMenu.getAction();
            } else if (!consoleMenu.getChilds().isEmpty()) {
                rsl = consoleMenu.getActionChild(itemName);
                if (!rsl.execute().equals("Нет действия")) {
                    break;
                }
            }
        }
        return rsl;
    }
}