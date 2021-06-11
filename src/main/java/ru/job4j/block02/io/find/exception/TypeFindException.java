package ru.job4j.block02.io.find.exception;

public class TypeFindException extends IllegalArgumentException {
    private String type;

    public TypeFindException(String message, String type) {
        super(message);
        this.type = type;
    }
}
