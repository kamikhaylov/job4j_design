package ru.job4j.block02.io;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalizyTest {
    @Test
    public void whenUnavailable() {
        String source = "data/server.log";
        String target = "data/unavailable.csv";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        List<String> rsl = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            for (String line = read.readLine();  line != null; line = read.readLine()) {
                rsl.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> expected = List.of(
                "10:57:01;10:59:01",
                "11:01:02;11:02:02"
        );
        assertThat(rsl, is(expected));
    }
}