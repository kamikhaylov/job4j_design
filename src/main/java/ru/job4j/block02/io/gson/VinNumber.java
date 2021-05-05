package ru.job4j.block02.io.gson;

public class VinNumber {
    private final String number;

    public VinNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "VinNumber{"
                + "number='" + number + '\''
                + '}';
    }
}