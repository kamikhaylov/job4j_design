package ru.job4j.block02.io.gson;

public class VinNumber {
    private String number;

    public VinNumber() {
    }

    public VinNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "VinNumber{"
                + "number='" + number + '\''
                + '}';
    }
}