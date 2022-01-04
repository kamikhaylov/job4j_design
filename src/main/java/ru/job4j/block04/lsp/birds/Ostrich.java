package ru.job4j.block04.lsp.birds;

public class Ostrich implements Bird {
    @Override
    public String fly() {
        return "Не умеет летать";
    }
}
