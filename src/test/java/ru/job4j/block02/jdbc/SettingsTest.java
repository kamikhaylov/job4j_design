package ru.job4j.block02.jdbc;

import org.junit.Test;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SettingsTest {
    @Test
    public void whenPath() throws Exception {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("ru/job4j/block02/jdbc/app.properties")) {
            settings.load(io);
        }
        String value = settings.getValue("driver_class");
        assertThat(value, is("org.postgresql.Driver"));
    }
}