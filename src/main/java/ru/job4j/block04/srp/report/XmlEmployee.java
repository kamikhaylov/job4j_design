package ru.job4j.block04.srp.report;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "xmlEmployees")
public class XmlEmployee {
    private List<Employee> xmlEmployees;

    public XmlEmployee() {
    }

    public XmlEmployee(List<Employee> xmlEmployees) {
        this.xmlEmployees = xmlEmployees;
    }

    public List<Employee> getXmlEmployee() {
        return xmlEmployees;
    }

    public void setXmlEmployee(List<Employee> xmlEmployees) {
        this.xmlEmployees = xmlEmployees;
    }
}
