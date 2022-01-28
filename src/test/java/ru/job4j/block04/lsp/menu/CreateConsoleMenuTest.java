package ru.job4j.block04.lsp.menu;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.List;

public class CreateConsoleMenuTest {
    @Test
    public void thenAddMenuWhenOutput() {
        CreateConsoleMenu menu = new CreateConsoleMenu();
        menu.create();
        menu.add("Задача 1.", new SimpleAction("Действие 1"));
        menu.add("Задача 1.", "Задача 1.1.", new SimpleAction("Действие 2"));
        menu.add("Задача 1.1.", "Задача 1.1.1.", new SimpleAction("Действие 3"));
        menu.add("Задача 1.1.", "Задача 1.1.2.", new SimpleAction("Действие 4"));
        menu.add("Задача 1.1.", "Задача 1.1.3.", new SimpleAction("Действие 5"));
        menu.add("Задача 1.", "Задача 1.2.", new SimpleAction("Действие 6"));
        menu.add("Задача 2.", new SimpleAction("Действие 7"));
        menu.add("Задача 2.", "Задача 2.1.", new SimpleAction("Действие 8"));
        menu.add("Задача 2.1.", "Задача 2.1.1.", new SimpleAction("Действие 9"));
        menu.add("Задача 2.1.1.", "Задача 2.1.1.1.", new SimpleAction("Действие 10"));
        menu.add("Задача 3.", new SimpleAction("Действие 11"));
        String expected = "Задача 1.\n"
                        + "--- Задача 1.1.\n"
                        + "--- --- Задача 1.1.1.\n"
                        + "--- --- Задача 1.1.2.\n"
                        + "--- --- Задача 1.1.3.\n"
                        + "--- Задача 1.2.\n"
                        + "Задача 2.\n"
                        + "--- Задача 2.1.\n"
                        + "--- --- Задача 2.1.1.\n"
                        + "--- --- --- Задача 2.1.1.1.\n"
                        + "Задача 3.\n";
        assertThat(menu.output(), is(expected));
    }

    @Test
    public void thenAddMenuWhenAction() {
        CreateConsoleMenu menu = new CreateConsoleMenu();
        menu.create();
        menu.add("Задача 1.", new SimpleAction("Действие 1"));
        menu.add("Задача 1.", "Задача 1.1.", new SimpleAction("Действие 2"));
        menu.add("Задача 1.1.", "Задача 1.1.1.", new SimpleAction("Действие 3"));
        menu.add("Задача 1.1.", "Задача 1.1.2.", new SimpleAction("Действие 4"));
        menu.add("Задача 1.1.", "Задача 1.1.3.", new SimpleAction("Действие 5"));
        menu.add("Задача 1.", "Задача 1.2.", new SimpleAction("Действие 6"));
        menu.add("Задача 2.", new SimpleAction("Действие 7"));
        menu.add("Задача 2.", "Задача 2.1.", new SimpleAction("Действие 8"));
        menu.add("Задача 2.1.", "Задача 2.1.1.", new SimpleAction("Действие 9"));
        menu.add("Задача 2.1.1.", "Задача 2.1.1.1.", new SimpleAction("Действие 10"));
        menu.add("Задача 3.", new SimpleAction("Действие 11"));
        List<String> rsl = List.of(
                menu.select("Задача 1.").execute(),
                menu.select("Задача 1.1.").execute(),
                menu.select("Задача 1.1.1.").execute(),
                menu.select("Задача 1.1.2.").execute(),
                menu.select("Задача 1.1.3.").execute(),
                menu.select("Задача 1.2.").execute(),
                menu.select("Задача 2.").execute(),
                menu.select("Задача 2.1.").execute(),
                menu.select("Задача 2.1.1.").execute(),
                menu.select("Задача 2.1.1.1.").execute(),
                menu.select("Задача 3.").execute()
                );
        List<String> expected = List.of(
                "Действие 1",
                "Действие 2",
                "Действие 3",
                "Действие 4",
                "Действие 5",
                "Действие 6",
                "Действие 7",
                "Действие 8",
                "Действие 9",
                "Действие 10",
                "Действие 11"
        );
        assertThat(rsl, is(expected));
    }
}