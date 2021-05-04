package ru.job4j.block02.io.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4jOut {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Auto";
        int year = 2017;
        byte petrol = 98;
        short length = 5091;
        long width = 1902L;
        float height = 1538F;
        double wheelbase = 3070D;
        char kpp = 'A';
        boolean sale = true;
        LOG.debug("Auto info name: {}, year: {}, petrol: {}, kpp: {}", name, year, petrol, kpp);
        LOG.debug("length x width x height: {} x {} x {} mm", length, width, height);
        LOG.debug("Sale: {}", sale);
    }
}