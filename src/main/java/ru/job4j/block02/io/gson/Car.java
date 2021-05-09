package ru.job4j.block02.io.gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private boolean sale;
    private int year;
    private String name;
    private VinNumber vin;
    private String[] service;

    public Car() {
    }

    public Car(boolean sale, int year, String name, VinNumber vin, String[] service) {
        this.sale = sale;
        this.year = year;
        this.name = name;
        this.vin = vin;
        this.service = service;
    }

    public boolean isSale() {
        return sale;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public VinNumber getVin() {
        return vin;
    }

    public String[] getService() {
        return service;
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
        JSONObject jsonVin = new JSONObject("{\"number\":\"ZZZZZZZZ\"}");
        List<String> list = new ArrayList<>();
        list.add("10-10-2017");
        list.add("15-10-2018");
        list.add("12-10-2019");
        JSONArray jsonServices = new JSONArray(list);
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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sale", car.isSale());
        jsonObject.put("year", car.getYear());
        jsonObject.put("name", car.getName());
        jsonObject.put("vin", jsonVin);
        jsonObject.put("service", jsonServices);

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(car));
    }
}