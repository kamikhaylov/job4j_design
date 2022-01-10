package ru.job4j.block04.lsp.parking;

public class ParkingCarsAndTrucks implements Parking {
    @Override
    public boolean add(Car car) {
        return false;
    }

    @Override
    public boolean accept(Car car) {
        return false;
    }
}
