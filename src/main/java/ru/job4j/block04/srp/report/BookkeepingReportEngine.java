package ru.job4j.block04.srp.report;

import java.util.function.Predicate;

public class BookkeepingReportEngine implements Report {
    private Store store;

    public BookkeepingReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * 0.2).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
