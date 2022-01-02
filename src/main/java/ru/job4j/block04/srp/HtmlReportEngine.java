package ru.job4j.block04.srp;

import java.util.function.Predicate;

public class HtmlReportEngine implements Report {
    private Store store;

    public HtmlReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html><html><head><title>HtmlReport</title></head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append("<table>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</tr>")
                .append("<tbody>");
        for (Employee employee : store.findBy(filter)) {
            html.append("<tr>")
                    .append("<td>")
                    .append(employee.getName())
                    .append("</td>")
                    .append("<td>")
                    .append(employee.getHired())
                    .append("</td>")
                    .append("<td>")
                    .append(employee.getFired())
                    .append("</td>")
                    .append("<td>")
                    .append(employee.getSalary())
                    .append("</td>")
                    .append("</tr>");
        }
        html.append("</tbody>")
                .append("</table>")
                .append("</body>")
                .append("</html>");
        return html.toString();
    }
}
