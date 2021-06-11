package ru.job4j.block02.io.find.exception;

public class ResultNameException extends IllegalArgumentException {
    private String name;

    public ResultNameException(String message, String name) {
        super(message);
        this.name = name;
    }
}
