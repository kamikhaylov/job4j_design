package ru.job4j.block04.srp.report;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class JsonReportTest {
    @Test
    public void whenJsonGenerated() {
        MemStore store = new MemStore();
        Calendar time = Calendar.getInstance();
        time.set(2022, Calendar.JANUARY, 3, 0, 0, 0);
        Employee worker = new Employee("Ivan", time, time, 100);
        store.add(worker);
        Report jsonReport = new JsonReport(store);
        String expect =
                "["
                + "{"
                    + "\"name\":\"Ivan\","
                    + "\"hired\":"
                    + "{"
                        + "\"year\":2022,"
                        + "\"month\":0,"
                        + "\"dayOfMonth\":3,"
                        + "\"hourOfDay\":0,"
                        + "\"minute\":0,"
                        + "\"second\":0"
                    + "},"
                    + "\"fired\":"
                    + "{\"year\":2022,"
                        + "\"month\":0,"
                        + "\"dayOfMonth\":3,"
                        + "\"hourOfDay\":0,"
                        + "\"minute\":0,"
                        + "\"second\":0"
                    + "},"
                    + "\"salary\":100.0"
                + "}"
                + "]"
                + "\n";
        assertThat(jsonReport.generate(em -> true), is(expect));
    }
}