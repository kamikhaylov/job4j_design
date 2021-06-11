package ru.job4j.block02.io.find.service;

import ru.job4j.block02.io.find.strategies.*;
import ru.job4j.block02.io.find.validation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Find {
    private final static String NAME = "name";
    private final static String MASK = "mask";
    private final static String REGEX = "regex";
    private Parameters parameters;
    private String directory;
    private String type;
    private String nameFind;
    private String nameResult;
    private FindStrategy findStrategy;
    private List<Path> result;

    public Find(String[] args) {
        this.parameters = Parameters.of(args);
        this.directory = parameters.get("d");
        this.type = parameters.get("t");
        this.nameFind = parameters.get("n");
        this.nameResult = parameters.get("o");
    }

    public void run() throws IOException {
        validatorParameters();
        Path start = Paths.get(directory);
        selectionFindType(type);
        Predicate<Path> condition = findStrategy.getPredicate(nameFind);
        printFileRsl(nameResult, search(start, condition));
    }

    private Searcher search(Path root, Predicate<Path> condition) throws IOException {
        Searcher searcher = new Searcher(condition);
        Files.walkFileTree(root, searcher);
        return searcher;
    }

    private void selectionFindType(String type) {
        if (type.equals(NAME)) {
            findStrategy = new FindName();
        } else if (type.equals(MASK)) {
            findStrategy = new FindMask();
        } else if (type.equals(REGEX)) {
            findStrategy = new FindRegex();
        }
    }

    private void printFileRsl(String path, Searcher searcher) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(path))) {
            for (Path p : searcher.getPaths()) {
                writer.println(p.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validatorParameters() {
        ValidatorParameters validatorParameters = new ValidatorParameters(
                directory,
                type,
                nameFind,
                nameResult
        );
        validatorParameters
                .checkDirectory()
                .checkType()
                .checkNameFind()
                .checkNameRsl();
    }
}