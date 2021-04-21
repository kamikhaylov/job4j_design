package ru.job4j.block02.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine();  line != null; line = in.readLine()) {
                if (line.contains("404")) {
                    rsl.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String s : log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printLogConsole(List<String> log) {
        for (String s : log) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("data//log.txt");
        printLogConsole(log);
        save(log, "data//404.txt");
    }
}