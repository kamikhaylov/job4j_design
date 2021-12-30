package ru.job4j.block04.template;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;
import java.util.NoSuchElementException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneratorNameTest {
    @Test
    public void whenGeneratorTrue() {
        Generator generator = new GeneratorName();
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Konstantin, Who are you?";
        Map<String, String> values = Map.of("Konstantin", "you");
        assertThat(expected, is(generator.produce(template, values)));
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void whenNotKeyInMap() {
        Generator generator = new GeneratorName();
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Konstantin, Who are you?";
        Map<String, String> values = Map.of("Ivan", "you");
        generator.produce(template, values);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenExtraKeyInMap() {
        Generator generator = new GeneratorName();
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Konstantin, Who are you?";
        Map<String, String> values = Map.of("Konstantin", "you",
                "Ivan", "you");
        generator.produce(template, values);
    }
}