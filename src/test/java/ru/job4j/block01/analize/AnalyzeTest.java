package ru.job4j.block01.analize;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.ArrayList;

public class AnalyzeTest {
    @Test
    public void whenChangedThenTwo() {
        Analyze analyze = new Analyze();
        ArrayList<User> previous = new ArrayList<>();
        ArrayList<User> current = new ArrayList<>();
        previous.add(new User(0, "Alex"));
        previous.add(new User(1, "Dick"));
        previous.add(new User(2, "Bob"));
        current.add(new User(0, "Alex"));
        current.add(new User(1, "NewDick"));
        current.add(new User(2, "NewBob"));
        Info rsl = analyze.diff(previous, current);
        Info expected = new Info(0, 2, 0);
        assertThat(rsl.getChanged(), is(expected.getChanged()));
    }

    @Test
    public void whenAddedThenTwo() {
        Analyze analyze = new Analyze();
        ArrayList<User> previous = new ArrayList<>();
        ArrayList<User> current = new ArrayList<>();
        previous.add(new User(0, "Alex"));
        previous.add(new User(1, "Dick"));
        previous.add(new User(2, "Bob"));
        current.add(new User(0, "Alex"));
        current.add(new User(1, "Dick"));
        current.add(new User(2, "Bob"));
        current.add(new User(3, "Did"));
        current.add(new User(4, "Robert"));
        Info rsl = analyze.diff(previous, current);
        Info expected = new Info(2, 0, 0);
        assertThat(rsl.getAdded(), is(expected.getAdded()));
    }

    @Test
    public void whenDeletedThenTwo() {
        Analyze analyze = new Analyze();
        ArrayList<User> previous = new ArrayList<>();
        ArrayList<User> current = new ArrayList<>();
        previous.add(new User(0, "Alex"));
        previous.add(new User(1, "Dick"));
        previous.add(new User(2, "Bob"));
        current.add(new User(2, "Bob"));
        Info rsl = analyze.diff(previous, current);
        Info expected = new Info(0, 0, 2);
        assertThat(rsl.getDeleted(), is(expected.getDeleted()));
    }

    @Test
    public void whenAddedChangedDeleted() {
        Analyze analyze = new Analyze();
        ArrayList<User> previous = new ArrayList<>();
        ArrayList<User> current = new ArrayList<>();
        previous.add(new User(0, "Alex"));
        previous.add(new User(1, "Dick"));
        previous.add(new User(2, "Bob"));
        previous.add(new User(3, "Did"));
        previous.add(new User(4, "Robert"));
        current.add(new User(0, "Alex"));
        current.add(new User(1, "NewDick"));
        current.add(new User(2, "NewBob"));
        current.add(new User(3, "NewDid"));
        current.add(new User(5, "NewRobert"));
        current.add(new User(6, "NewAlex"));
        Info rsl = analyze.diff(previous, current);
        Info expected = new Info(2, 3, 1);
        assertThat(rsl.getAdded(), is(expected.getAdded()));
        assertThat(rsl.getChanged(), is(expected.getChanged()));
        assertThat(rsl.getDeleted(), is(expected.getDeleted()));
    }

    @Test
    public void whenEqualCollections() {
        Analyze analyze = new Analyze();
        ArrayList<User> previous = new ArrayList<>();
        ArrayList<User> current = new ArrayList<>();
        previous.add(new User(0, "Alex"));
        previous.add(new User(1, "Dick"));
        previous.add(new User(2, "Bob"));
        current.add(new User(0, "Alex"));
        current.add(new User(1, "Dick"));
        current.add(new User(2, "Bob"));
        Info rsl = analyze.diff(previous, current);
        Info expected = new Info(0, 0, 0);
        assertThat(rsl.getAdded(), is(expected.getAdded()));
        assertThat(rsl.getChanged(), is(expected.getChanged()));
        assertThat(rsl.getDeleted(), is(expected.getDeleted()));
    }
}