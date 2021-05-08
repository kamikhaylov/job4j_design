package ru.job4j.block02.io.gson;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "vin")
public class VinNumber {

    @XmlAttribute
    private String number;

    public VinNumber() {
    }

    public VinNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "VinNumber{"
                + "number='" + number + '\''
                + '}';
    }
}