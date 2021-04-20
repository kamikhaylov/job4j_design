package ru.job4j.block02.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(5);
        String text = matrix.matrixToString(table);
        try (FileOutputStream out = new FileOutputStream("data//resultMatrix.txt")) {
            out.write(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
