package ru.job4j.block03.cache;
import java.util.Scanner;

public class Emulator extends DirFileCache {
    public Emulator(String cachingDir) {
        super(cachingDir);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите кэшируемую директорию: ");
        String dir = scanner.nextLine();
        DirFileCache dirFileCache = new DirFileCache(dir);
        Emulator emulator = new Emulator(dir);
        System.out.println("Чтобы загрузить содержимое файла в кэш - введите имя файла: ");
        String name = scanner.nextLine();
        emulator.load(name);
        System.out.println("Получить содержимое файла? Введите да: ");
        String answer = scanner.nextLine();
        if (answer.equals("да")) {
            String fileContents = emulator.get(name);
            if (fileContents != null) {
                System.out.println("Содержимое файла: " + System.lineSeparator()
                        + fileContents);
            } else {
                System.out.println("Содержимое файла: "  + System.lineSeparator()
                        + emulator.get(emulator.load(name)));
            }
        }
    }
}