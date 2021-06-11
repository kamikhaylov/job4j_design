package ru.job4j.block02.io.find.service;

import java.util.HashMap;
import java.util.Map;

public class Parameters {
    private final Map<String, String> values;

    public Parameters() {
        this.values = new HashMap<>();
    }

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String arg : args) {
            String[] arr = arg.split("=");
            if (arr.length != 2) {
                throw new IllegalArgumentException();
            }
            arr[0] = arr[0].substring(1);
            values.put(arr[0], arr[1]);
        }
    }

    public static Parameters of(String[] args) {
        Parameters names = new Parameters();
        names.parse(args);
        return names;
    }
}
