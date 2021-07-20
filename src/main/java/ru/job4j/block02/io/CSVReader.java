package ru.job4j.block02.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    private Path path;
    private String delimiter;
    private String out;
    private String filter;
    private ArrayList<String> argsFilter;

    public CSVReader(ArgsName argsName) {
        this.path = Path.of(argsName.get("path"));
        this.delimiter = argsName.get("delimiter");
        this.out = argsName.get("out");
        this.filter = argsName.get("filter");
    }

    private void getArgsFilter(String out) {
        argsFilter = new ArrayList<>();
        Scanner scanner = new Scanner(new ByteArrayInputStream(out.getBytes()))
                .useDelimiter(",");
        int i = 0;
        while (scanner.hasNext()) {
            argsFilter.add(scanner.next());
        }
    }

    public void reader() {
        getArgsFilter(filter);
        if (out.equals("stdout")) {
            stdOut();
        } else if (out.equals("file")) {
            fileOut();
        }
    }

    private void stdOut() {
        try (Scanner scArgs = new Scanner(path).useDelimiter(delimiter)) {
            while (scArgs.hasNext()) {
                String[] arr = scArgs.next().split("=");
                if (argsFilter.contains(arr[0])) {
                    System.out.println(arr[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fileOut() {
        try (Scanner scArgs = new Scanner(path).useDelimiter(delimiter)) {
            while (scArgs.hasNext()) {
                String[] arr = scArgs.next().split("=");
                if (argsFilter.contains(arr[0])) {
                    try (PrintWriter out = new PrintWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream("data/csv/resultFile.txt", true)
                            ))) {
                        out.write(arr[1] + System.lineSeparator());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException(
                    "Root folder is null. Usage java -jar search.jar FILE_PATH,"
                            + "DELIMITER, "
                            + "OUTPUT (key = stdout or path), "
                            + "FILTER (name,age,birthDate,education,children)"
            );
        }
        CSVReader csvReader = new CSVReader(ArgsName.of(args));
        csvReader.reader();
    }
}