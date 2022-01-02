package ru.job4j.block04.srp;

import org.junit.Test;
import java.util.Calendar;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HtmlReportEngineTest {
    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee proger = new Employee("Ivan", now, now, 100);
        store.add(proger);
        Report engine = new HtmlReportEngine(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html><html><head><title>HtmlReport</title></head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append("<table>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</tr>")
                .append("<tbody>")
                .append("<tr>")
                .append("<td>")
                .append(proger.getName())
                .append("</td>")
                .append("<td>")
                .append(proger.getHired())
                .append("</td>")
                .append("<td>")
                .append(proger.getFired())
                .append("</td>")
                .append("<td>")
                .append(proger.getSalary())
                .append("</td>")
                .append("</tr>")
                .append("</tbody>")
                .append("</table>")
                .append("</body>")
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}