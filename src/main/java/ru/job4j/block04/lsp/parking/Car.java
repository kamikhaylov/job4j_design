package ru.job4j.block04.lsp.parking;

import java.util.Objects;

public class Car {
    private String name;
    private int size;

    public Car(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return size == car.size && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}
