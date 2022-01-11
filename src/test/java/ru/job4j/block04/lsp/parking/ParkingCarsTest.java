package ru.job4j.block04.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParkingCarsTest {
    @Ignore
    @Test
    public void thenOneCarWhenOneParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Car car = new Car("Car1", 1);
        parking.add(car);
        List<Car> expected = new ArrayList<>(4);
        expected.add(car);
        assertThat(parking.findAll(), is(expected));
    }

    @Ignore
    @Test
    public void thenOneTrackWhenTwoParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Car track = new Car("Track1", 2);
        parking.add(track);
        List<Car> expected = new ArrayList<>(4);
        expected.add(track);
        expected.add(track);
        assertThat(parking.findAll(), is(expected));
    }

    @Ignore
    @Test
    public void thenOneCarAndOneTkackWhenThreeParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Car car = new Car("Car", 1);
        Car track = new Car("Track1", 2);
        parking.add(car);
        parking.add(track);
        List<Car> expected = new ArrayList<>(4);
        expected.add(car);
        expected.add(track);
        expected.add(track);
        assertThat(parking.findAll(), is(expected));
    }

    @Ignore
    @Test
    public void thenTwoCarsWhenTwoParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Car car1 = new Car("Car1", 1);
        Car car2 = new Car("Car2", 1);
        parking.add(car1);
        parking.add(car2);
        List<Car> expected = new ArrayList<>(4);
        expected.add(car1);
        expected.add(car2);
        assertThat(parking.findAll(), is(expected));
    }

    @Ignore
    @Test
    public void thenTwoTracksWhenTwoParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Car track1 = new Car("Track1", 2);
        Car track2 = new Car("Track2", 2);
        parking.add(track1);
        parking.add(track2);
        List<Car> expected = new ArrayList<>(4);
        expected.add(track1);
        expected.add(track1);
        expected.add(track2);
        expected.add(track2);
        assertThat(parking.findAll(), is(expected));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void thenThreeCarsWhenNoPlaces() {
        ParkingCars parking = new ParkingCars(2, 2);
        Car car1 = new Car("Car1", 1);
        Car car2 = new Car("Car2", 1);
        Car car3 = new Car("Car3", 1);
        parking.add(car1);
        parking.add(car2);
        parking.add(car3);
    }

    @Ignore
    @Test
    public void thenThreeTracksWhenFourParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Car track1 = new Car("Track1", 2);
        Car track2 = new Car("Track2", 2);
        Car track3 = new Car("Track3", 2);
        parking.add(track1);
        parking.add(track2);
        parking.add(track3);
        List<Car> expected = new ArrayList<>(4);
        expected.add(track1);
        expected.add(track2);
        expected.add(track3);
        expected.add(track3);
        assertThat(parking.findAll(), is(expected));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void thenOneCarAndThreeTracksWhenNoPlaces() {
        ParkingCars parking = new ParkingCars(2, 2);
        Car car = new Car("Car1", 1);
        Car track1 = new Car("Track1", 2);
        Car track2 = new Car("Track2", 2);
        Car track3 = new Car("Track3", 2);
        parking.add(car);
        parking.add(track1);
        parking.add(track2);
        parking.add(track3);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void thenOneCarWhenNoPlaces() {
        ParkingCars parking = new ParkingCars(0, 2);
        Car car = new Car("Car1", 1);
        parking.add(car);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void thenOneTrackWhenNoPlaces() {
        ParkingCars parking = new ParkingCars(1, 0);
        Car track = new Car("track1", 2);
        parking.add(track);
    }

    @Ignore
    @Test
    public void thenTwoSuperTracksWhenFourParkingCars() {
        ParkingCars parking = new ParkingCars(3, 1);
        Car superTrack1 = new Car("SuperTrack1", 3);
        Car superTrack2 = new Car("SuperTrack2", 3);
        parking.add(superTrack1);
        parking.add(superTrack2);
        List<Car> expected = new ArrayList<>(4);
        expected.add(superTrack1);
        expected.add(superTrack2);
        expected.add(superTrack2);
        expected.add(superTrack2);
        assertThat(parking.findAll(), is(expected));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void thenOneCarAndTwoSuperTracksWhenNoPlaces() {
        ParkingCars parking = new ParkingCars(3, 1);
        Car car = new Car("Car1", 1);
        Car superTrack1 = new Car("SuperTrack1", 3);
        Car superTrack2 = new Car("SuperTrack2", 3);
        parking.add(car);
        parking.add(superTrack1);
        parking.add(superTrack2);
        parking.add(superTrack2);
        parking.add(superTrack2);
    }
}