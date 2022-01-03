package ru.job4j.block04.srp.report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XmlReport implements Report {
    private Store store;

    public XmlReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        String xml = "";
        try {
            JAXBContext context = JAXBContext.newInstance(XmlEmployee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(new XmlEmployee(employees), writer);
                xml = writer.getBuffer().toString();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
