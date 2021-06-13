package ru.job4j.block02.io.find;

import ru.job4j.block02.io.find.service.Find;
import ru.job4j.block02.io.find.validation.ValidatorParameters;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ValidatorParameters.checkArg(args);
        Find find = new Find(args);
        find.run();
    }
}