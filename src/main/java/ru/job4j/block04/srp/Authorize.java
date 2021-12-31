package ru.job4j.block04.srp;

import java.util.List;

public interface Authorize {
    void loginAccount();

    List<String> loginHistory();
}
