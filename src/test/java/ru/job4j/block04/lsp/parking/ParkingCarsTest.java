package ru.job4j.block04.lsp.parking;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParkingCarsTest {
    @Test
    public void thenOneCarWhenOneParkingCars() {
        ParkingCars parking = new ParkingCars(1, 0);
        Vehicle car = new Car("Car1");
        parking.add(car);
        assertThat(parking.findAll(), is(List.of(car)));
    }

    @Test
    public void thenOneTrackWhenOneParkingCars() {
        ParkingCars parking = new ParkingCars(0, 1);
        Vehicle track = new Track("Track1", 2);
        parking.add(track);
        assertThat(parking.findAll(), is(List.of(track)));
    }

    @Test
    public void thenOneCarAndOneTrackWhenTwoParkingCars() {
        ParkingCars parking = new ParkingCars(1, 1);
        Vehicle car = new Car("Car");
        Vehicle track = new Track("Track1", 2);
        parking.add(car);
        parking.add(track);
        assertThat(parking.findAll(), is(List.of(car, track)));
    }

    @Test
    public void thenTwoCarsWhenTwoParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Vehicle car1 = new Car("Car1");
        Vehicle car2 = new Car("Car2");
        parking.add(car1);
        parking.add(car2);
        assertThat(parking.findAll(), is(List.of(car1, car2)));
    }

    @Test
    public void thenTwoTracksWhenTwoParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Vehicle track1 = new Track("Track1", 2);
        Vehicle track2 = new Track("Track2", 2);
        parking.add(track1);
        parking.add(track2);
        assertThat(parking.findAll(), is(List.of(track1, track2)));
    }

    @Test
    public void thenThreeTracksWhenFourParkingCars() {
        ParkingCars parking = new ParkingCars(2, 2);
        Vehicle track1 = new Track("Track1", 2);
        Vehicle track2 = new Track("Track2", 2);
        Vehicle track3 = new Track("Track3", 2);
        parking.add(track1);
        parking.add(track2);
        parking.add(track3);
        assertThat(parking.findAll(), is(List.of(track1, track2, track3, track3)));
    }

    @Test
    public void thenTwoSuperTracksWhenFourParkingCars() {
        ParkingCars parking = new ParkingCars(3, 1);
        Vehicle superTrack1 = new Track("SuperTrack1", 3);
        Vehicle superTrack2 = new Track("SuperTrack2", 3);
        parking.add(superTrack1);
        parking.add(superTrack2);
        assertThat(parking.findAll(), is(List.of(
                superTrack1, superTrack2, superTrack2, superTrack2)));
    }
}