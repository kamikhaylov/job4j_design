package ru.job4j.block02.io.find.validation;

import ru.job4j.block02.io.find.exception.DirectoryException;
import ru.job4j.block02.io.find.exception.ResultNameException;
import ru.job4j.block02.io.find.exception.TypeFindException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ValidatorParameters {
    private final static String NAME = "name";
    private final static String MASK = "mask";
    private final static String REGEX = "regex";
    private String directory;
    private String type;
    private String nameFind;
    private String nameRsl;

    public ValidatorParameters(String directory, String type, String nameFind, String nameRsl) {
        this.directory = directory;
        this.type = type;
        this.nameFind = nameFind;
        this.nameRsl = nameRsl;
    }

    public ValidatorParameters checkDirectory() {
        if (!Files.exists(Paths.get(directory))) {
            throw new DirectoryException("Directory does not exist "
                    + directory, directory);
        }
        return this;
    }

    public ValidatorParameters checkType() {
        if (!(type.equals(NAME) || type.equals(MASK) || type.equals(REGEX))) {
            if (!type.equals(NAME)) {
                throw new TypeFindException("Directory does not exist " + type
                        + ". Usage type:  name, mask, regex", type);
            }
        }
        return this;
    }

    public ValidatorParameters checkNameFind() {
        if (type.equals(NAME)) {
            String[] arr = nameFind.split("\\.");
            if (arr.length != 2) {
                throw new TypeFindException("To search by name - "
                        + "the file name must contain name.extension " + nameFind, nameFind);
            }
        }
        if (type.equals(MASK)) {
            String[] arr = nameFind.split("\\.");
            if (arr.length != 2 && arr[0] != "*") {
                throw new TypeFindException("To search by mask - "
                        + "the file name must contain character *.extension "
                        + nameFind, nameFind);
            }
        }
        if (type.equals(REGEX)) {
            if (nameFind.isEmpty()) {
                throw new TypeFindException("To search by regex - "
                        + "the file name must contain character contain regex "
                        + nameFind, nameFind);
            }
        }
        return this;
    }

    public ValidatorParameters checkNameRsl() {
        String[] arr = nameRsl.split("\\.");
        if (arr.length != 2) {
            throw new ResultNameException("To search by name - "
                    + "the file name must contain name.extension "
                    + nameRsl, nameRsl);
        }
        return this;
    }

    public static void checkArg(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException(
                    "Root folder is null. Usage java -jar find.jar "
                            + "DIRECTORY, "
                            + "TYPE_FIND (name, mask, regex), "
                            + "FILENAME_TO_FIND, "
                            + "FILENAME_TO_RESULT."
            );
        }
    }
}