package ru.job4j.block04.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingCars implements Parking {
    private int placesCars;
    private int placesTracks;
    private List<Car> cars;
    private int occupiedPlacesCars;
    private int occupiedPlacesTracks;

    public ParkingCars(int placesCars, int placesTracks) {
        this.placesCars = placesCars;
        this.placesTracks = placesTracks;
        this.cars = new ArrayList<>(placesCars + placesTracks);
    }

    @Override
    public boolean add(Car car) {
        boolean rsl = false;
        if (car.getSize() == 1) {
            rsl = addCar(car);
        } else if (car.getSize() > 1) {
            rsl = addTrack(car);
        }
        return rsl;
    }

    private boolean addCar(Car car) {
        boolean rsl = false;
        if (car.getSize() <= placesCars && occupiedPlacesCars < placesCars) {
            cars.add(car);
            occupiedPlacesCars++;
            rsl = true;
        } else {
            throw new IllegalArgumentException(
                    "Нет свободных парковочных мест для легкового автомобиля");
        }
        return rsl;
    }

    private boolean addTrack(Car car) {
        boolean rsl = false;
        if (occupiedPlacesTracks < placesTracks) {
            rsl = addTrackInParkingTrack(car);
        } else if (car.getSize() <= placesCars && occupiedPlacesCars < placesCars) {
            rsl = addTrackInParkingCar(car);
        } else {
            throw new IllegalArgumentException(
                    "Нет свободных парковочных мест для грузового автомобиля"
                           + "на местах грузовых и легковых автомобилей");
        }
        return rsl;
    }

    private boolean addTrackInParkingTrack(Car car) {
        cars.add(car);
        occupiedPlacesTracks++;
        return true;
    }

    private boolean addTrackInParkingCar(Car car) {
        for (int i = 0; i < car.getSize(); i++) {
            if (occupiedPlacesCars < placesCars) {
                cars.add(car);
                occupiedPlacesCars++;
            } else {
                throw new IllegalArgumentException(
                        "Нет свободных парковочных мест для грузового автомобиля"
                               + "на местах леговых автомобилей");
            }
        }
        return true;
    }

    public List<Car> findAll() {
        return (List<Car>) ((ArrayList<Car>) this.cars).clone();
    }
}