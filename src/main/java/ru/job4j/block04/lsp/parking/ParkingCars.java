package ru.job4j.block04.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingCars implements Parking {
    private int placesCars;
    private int placesTracks;
    private List<Car> cars;

    public ParkingCars(int placesCars, int placesTracks) {
        this.placesCars = placesCars;
        this.placesTracks = placesTracks;
        this.cars = new ArrayList<>(placesCars + placesTracks);
    }

    @Override
    public boolean add(Car car) {
        return false;
    }

    public List<Car> findAll() {
        return new ArrayList<>();
    }
}
