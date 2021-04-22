package ru.job4j.block02.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(s -> !s.contains("#"))
                    .filter(s -> !s.trim().isEmpty())
                    .forEach(s -> {
                        String key = s.split("=")[0].trim();
                        String value = s.substring(s.lastIndexOf("=") + 1);
                        if (key.length() == 0 || value.length() == 0) {
                            throw new IllegalArgumentException("Не содержит ключ или значение");
                        }
                        values.put(key, value);
                        }
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("data/config/app.properties");
        System.out.println(config);
        config.load();
        System.out.println(config.value("hibernate.connection.username"));
    }
}