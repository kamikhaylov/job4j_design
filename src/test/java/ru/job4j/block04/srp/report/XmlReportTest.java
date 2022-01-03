package ru.job4j.block04.srp.report;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class XmlReportTest {
    @Test
    public void whenXmlGenerated() throws DatatypeConfigurationException {
        MemStore store = new MemStore();
        Calendar time = Calendar.getInstance();
        time.set(2022, Calendar.JANUARY, 3, 0, 0, 0);
        Employee worker = new Employee("Ivan", time, time, 100);
        store.add(worker);
        Report xmlReport = new XmlReport(store);
        XMLGregorianCalendar date = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar((GregorianCalendar) time);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<xmlEmployees>\n"
                + "    <xmlEmployee>\n"
                + "        <fired>" + date + "</fired>\n"
                + "        <hired>" + date + "</hired>\n"
                + "        <name>Ivan</name>\n"
                + "        <salary>100.0</salary>\n"
                + "    </xmlEmployee>\n"
                + "</xmlEmployees>"
                + System.lineSeparator();
        assertThat(xmlReport.generate(em -> true), is(expect));
    }
}