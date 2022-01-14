package ru.job4j.block04.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingCars implements Parking {
    private int placesCars;
    private int placesTracks;
    private List<Vehicle> cars;

    public ParkingCars(int placesCars, int placesTracks) {
        this.placesCars = placesCars;
        this.placesTracks = placesTracks;
        this.cars = new ArrayList<>(placesCars + placesTracks);
    }

    @Override
    public boolean add(Vehicle vehicle) {
        boolean rsl = false;
        if (vehicle.getSize() == 1 && placesCars > 0) {
            cars.add(vehicle);
            placesCars--;
            rsl = true;
        }
        if (vehicle.getSize() > 1) {
            if (placesTracks > 0) {
                cars.add(vehicle);
                placesTracks--;
                rsl = true;
            } else if (vehicle.getSize() <= placesCars) {
                for (int i = 0; i < vehicle.getSize(); i++) {
                    cars.add(vehicle);
                }
                placesCars -= vehicle.getSize();
                rsl = true;
            }
        }
        return rsl;
    }

    public List<Vehicle> findAll() {
        return (List<Vehicle>) ((ArrayList<Vehicle>) this.cars).clone();
    }
}