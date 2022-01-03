package ru.job4j.block04.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class JsonReport implements Report {
    private Store store;

    public JsonReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> employees = store.findBy(filter);
        final Gson gson = new GsonBuilder().create();
        for (Employee employee : employees) {
            text.append(gson.toJson(employee))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
