package ru.job4j.block04.dip;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Car {
    private String name;
    private Engine engine;
    private int speed;
    private Map<String, Set<String>> cars;

    public Car(String name, Engine engine, int speed) {
        this.cars = new HashMap<>();
        this.name = name;
        this.engine = engine;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getSpeed() {
        return speed;
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
        return speed == car.speed && Objects.equals(name, car.name) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, engine, speed);
    }

    public void printSpecifications() {
        System.out.println(name + " " + engine + " " + speed);
    }
}
