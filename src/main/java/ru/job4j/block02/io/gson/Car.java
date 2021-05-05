package ru.job4j.block02.io.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private final boolean sale;
    private final int year;
    private final String name;
    private final VinNumber vin;
    private final String[] service;

    public Car(boolean sale, int year, String name, VinNumber vin, String[] service) {
        this.sale = sale;
        this.year = year;
        this.name = name;
        this.vin = vin;
        this.service = service;
    }

    @Override
    public String toString() {
        return "Car{"
                + "sale=" + sale
                + ", year=" + year
                + ", name='" + name + '\''
                + ", vin=" + vin
                + ", service=" + Arrays.toString(service)
                + '}';
    }

    public static void main(String[] args) {
        final Car car = new Car(
                true,
                2017,
                "Car",
                new VinNumber("XXXXXXXXX"),
                new String[]{
                        "10-10-2017",
                        "15-10-2018",
                        "12-10-2019"
        });
        System.out.println(car);

        /* Преобразуем объект person в json-строку и обратно. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        System.out.println(gson.fromJson(gson.toJson(car), Car.class));

        /* Модифицируем json-строку и обратно. */
        final String carJson =
                "{"
                    + "\"sale\":true,"
                    + "\"year\":2019,"
                    + "\"name\":BigCar,"
                    + "\"vin\":"
                        + "{"
                            + "\"number\":\"ZZZZZZZZ\""
                        + "},"
                    + "\"service\":"
                        + "[\"02-12-2019\",\"20-11-2020\"]"
                + "}";
        System.out.println(carJson);
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
        System.out.println(gson.toJson(carMod));
    }
}
