package ru.job4j.block02.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("/Users/konstantin/Desktop/MyMac/JAVAWORK/job4j/projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    String.format("Not exist %s", file.getAbsoluteFile())
            );
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", file.getAbsoluteFile())
            );
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            String[] arr = subfile.getAbsoluteFile().toString().split("/");
            System.out.println(arr[arr.length - 1]
                    + " - "
                    + subfile.getAbsoluteFile().length());
        }
    }
}