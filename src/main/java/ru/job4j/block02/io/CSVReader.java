package ru.job4j.block02.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CSVReader {
    private final Path path;
    private final String delimiter;
    private final String out;
    private final String filter;

    public CSVReader(ArgsName argsName) {
        this.path = Path.of(argsName.get("path"));
        this.delimiter = argsName.get("delimiter");
        this.out = argsName.get("out");
        this.filter = argsName.get("filter");
    }

    public void reader() throws IOException {
        StringBuilder outPrint = resultOut(getArgsFilter(filter));
        if (out.equals("stdout")) {
            System.out.println(outPrint);
        } else {
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(String.valueOf(outPrint));
            }
        }
    }

    private int[] getArgsFilter(String filter) throws IOException {
        Scanner scanner = new Scanner(path).useDelimiter(System.lineSeparator());
        String[] columns = scanner.next().split(delimiter);
        return IntStream.range(0, columns.length)
                .filter(i -> filter.contains(columns[i])).toArray();
    }

    private StringBuilder resultOut(int[] indexFilter) {
        StringBuilder result = new StringBuilder();
        try (Scanner scArgs = new Scanner(path).useDelimiter(System.lineSeparator())) {
            while (scArgs.hasNextLine()) {
                List<String> outColumns = List.of(scArgs.next().split(delimiter));
                for (int i = 0; i < indexFilter.length; i++) {
                    result.append(outColumns.get(indexFilter[i]));
                    if (i != indexFilter.length - 1) {
                        result.append(";");
                    }
                }
                result.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void checkArgs(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException(
                    "Root folder is null. Usage java -jar search.jar FILE_PATH,"
                            + "DELIMITER, "
                            + "OUTPUT (key = stdout or data/csv/resultFile.txt, "
                            + "FILTER (name,age,birthDate,education,children)"
            );
        }
    }

    public static void main(String[] args) throws IOException {
        checkArgs(args);
        CSVReader csvReader = new CSVReader(ArgsName.of(args));
        csvReader.reader();
    }
}