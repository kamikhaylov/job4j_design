package ru.job4j.block02.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/config/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"),
                is("org.postgresql.Driver"));
    }

    @Test
    public void whenComment() {
        String path = "./data/config/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertNull(config.value("test"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenIllegalArgumentException() {
        String path = "./data/config/pair_in_violation.properties";
        Config config = new Config(path);
        config.load();
    }
}