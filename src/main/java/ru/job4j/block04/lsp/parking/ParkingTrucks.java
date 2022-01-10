package ru.job4j.block04.lsp.parking;

public class ParkingTrucks implements Parking {
    @Override
    public boolean add(Car car) {
        return false;
    }

    @Override
    public boolean accept(Car car) {
        return false;
    }
}
