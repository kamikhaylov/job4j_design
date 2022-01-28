package ru.job4j.block04.lsp.menu;

public class SimpleAction implements Action {
    private String name;

    public SimpleAction(String name) {
        this.name = name;
    }

    @Override
    public String execute() {
        return name;
    }
}