package ru.job4j.block02.io;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                table[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return table;
    }

    public String matrixToString(int[][] table) {
        String rsl = "";
        for (int[] ints : table) {
            for (int anInt : ints) {
                rsl = anInt != ints[ints.length - 1] ? rsl + anInt + " " : rsl + anInt;
            }
            if (ints != table[table.length - 1]) {
                rsl += System.lineSeparator();
            }
        }
        return rsl;
    }
}