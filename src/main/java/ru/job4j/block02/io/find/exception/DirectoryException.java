package ru.job4j.block02.io.find.exception;

public class DirectoryException extends IllegalArgumentException {
    private String directory;

    public DirectoryException(String message, String directory) {
        super(message);
        this.directory = directory;
    }
}