package ru.job4j.block04.lsp.menu;

public class ConsoleMenu implements Menu, Action {
    private String name;
    private Action action;

    public ConsoleMenu(String name) {
        this.name = name;
    }

    public ConsoleMenu(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String output() {
        return getName() + System.lineSeparator();
    }

    @Override
    public void execute() {
        action.execute();
    }
}