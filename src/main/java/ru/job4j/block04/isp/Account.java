package ru.job4j.block04.isp;

import java.util.List;

public interface Account {
    boolean input();

    boolean output();

    List<String> history();

    String getBalance();

    String getLimits();
}