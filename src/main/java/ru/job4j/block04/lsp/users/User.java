package ru.job4j.block04.lsp.users;

public class User {
    private int id;
    private String access;
    private String profile;

    public String hasAccess(String actions) {
        return "Доступ ограничен";
    }

    public String updateProfile(String profile) {
        return "Профиль ограничен";
    }
}
