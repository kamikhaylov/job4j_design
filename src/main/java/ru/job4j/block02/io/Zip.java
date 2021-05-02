package ru.job4j.block02.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target.toFile().toString())))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().toString()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(source.toFile().toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException(
                    "Root folder is null. Usage java -jar search.jar "
                            + "DIRECTORY, EXCLUDE_FILE_EXTENSION, NAME_ZIP."
            );
        }
        Zip zip = new Zip();
        ArgsName argsName = ArgsName.of(args);
        List<Path> paths = Search.search(Path.of(
                argsName.get("d")), p -> !p.toFile().getName().endsWith(argsName.get("e")));
        zip.packFiles(paths, Paths.get(argsName.get("o")));
    }
}