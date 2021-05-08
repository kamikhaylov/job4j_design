package ru.job4j.block02.io.gson;

import java.io.StringReader;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @XmlAttribute
    private boolean sale;
    private int year;
    private String name;
    private VinNumber vin;
    @XmlElementWrapper(name = "services")
    @XmlElement(name = "service")
    private String[] service;

    public Car() {
    }

    public Car(boolean sale, int year, String name, VinNumber vin, String[] service) {
        this.sale = sale;
        this.year = year;
        this.name = name;
        this.vin = vin;
        this.service = service;
    }

    @Override
    public String toString() {
        return "Car{"
                + "sale=" + sale
                + ", year=" + year
                + ", name='" + name + '\''
                + ", vin=" + vin
                + ", service=" + Arrays.toString(service)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        final Car car = new Car(
                true,
                2017,
                "Car",
                new VinNumber("XXXXXXXXX"),
                new String[]{
                        "10-10-2017",
                        "15-10-2018",
                        "12-10-2019"
        });

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Car result = (Car) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}