package ru.job4j.block02.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import static java.nio.file.FileVisitResult.CONTINUE;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, String> files;

    public DuplicatesVisitor() {
        this.files = new HashMap<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty fileProperty = new FileProperty(
                file.toFile().length(),
                file.toFile().getName()
        );
        if (!files.containsKey(fileProperty)) {
            files.put(fileProperty, fileProperty.getName());
        } else {
            System.out.println("У файла: " + fileProperty.getName());
            System.out.println("Найден дубликат: " + file.toAbsolutePath());
        }
        return CONTINUE;
    }
}