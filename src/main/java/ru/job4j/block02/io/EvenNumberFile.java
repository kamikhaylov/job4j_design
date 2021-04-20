package ru.job4j.block02.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data//even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line + " - " + evenStatus(even(Integer.parseInt(line))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean even(int numb) {
        return numb % 2 == 0;
    }

    public static String evenStatus(boolean even) {
        return even ? "число четное" : "число нечетное";
    }
}