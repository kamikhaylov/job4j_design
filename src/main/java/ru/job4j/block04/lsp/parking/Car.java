package ru.job4j.block04.lsp.parking;

import java.util.Objects;

public class Car implements Vehicle {
    private static final int SIZE = 1;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return SIZE;
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
        return SIZE == car.SIZE && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, SIZE);
    }
}
