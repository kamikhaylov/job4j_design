package ru.job4j.block04.isp;

import java.util.List;

public interface Payment {
    boolean pay(String s);

    boolean status(String s);

    List<String> findAll(String s);

    String findID(String s);
}
