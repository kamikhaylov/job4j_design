package ru.job4j.block02.io.cd;

import java.util.LinkedList;
import java.util.StringJoiner;

public class Shell {
    private LinkedList<String> list;
    private String[] arr;

    public Shell() {
        this.list = new LinkedList<>();
    }

    public void cd(String path) {
        arr = path.split("/");
        if (path.startsWith("/")) {
            list.clear();
            absolutePath(path, arr);
        } else {
            relativePath(path, arr);
        }
    }

    public String pwd() {
        StringJoiner str = new StringJoiner("/", "/", "");
        for (String s : list) {
            str.add(s);
        }
        return str.toString();
    }

    private void absolutePath(String path, String[] arr) {
        for (String s : arr) {
            if (s.equals("")) {
                continue;
            }
            list.addLast(s);
        }
    }

    private void relativePath(String path, String[] arr) {
        for (String s : arr) {
            if (s.equals("..")) {
                list.removeLast();
            } else {
                list.addLast(s);
            }
        }
    }
}