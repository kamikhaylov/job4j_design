package ru.job4j.block02.io.cd;

import java.util.LinkedList;
import java.util.StringJoiner;

public class Shell {
    private LinkedList<String> list;
    private StringJoiner str;
    private String[] arr;

    public Shell() {
        this.list = new LinkedList<>();
        this.str = new StringJoiner("/", "/", "");
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
        while (!list.isEmpty()) {
            str.add(list.pollFirst());
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