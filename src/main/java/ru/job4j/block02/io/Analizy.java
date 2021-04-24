package ru.job4j.block02.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean startPeriod = false;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                for (String line = read.readLine();  line != null; line = read.readLine()) {
                    String[] arr = line.split(" ");
                    if ((arr[0].equals("400") || arr[0].equals("500"))
                            && !startPeriod) {
                        startPeriod = true;
                        out.print(arr[1] + ";");
                    } else if (!arr[0].equals("400") && !arr[0].equals("500")
                            && startPeriod) {
                        startPeriod = false;
                        out.println(arr[1]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}