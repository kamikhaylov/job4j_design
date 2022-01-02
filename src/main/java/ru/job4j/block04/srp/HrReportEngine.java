package ru.job4j.block04.srp;

import java.util.List;
import java.util.function.Predicate;

public class HrReportEngine implements Report {
    private Store store;

    public HrReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> sortStore = store.findBy(filter);
        SalaryComparator salaryComparator = new SalaryComparator();
        sortStore.sort(salaryComparator);
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee employee : sortStore) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
