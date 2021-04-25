package ru.job4j.block02.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenUnavailable1() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        List<String> rsl = new ArrayList<>();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
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

    @Test
    public void whenUnavailable2() {
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