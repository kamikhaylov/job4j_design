package ru.job4j.block04.lsp.users;

public class EmployeeUser extends User {
    private int id;
    private String access;
    private String profile;

    @Override
    public String hasAccess(String actions) {
        return "Доступ сотрудник";
    }

    @Override
    public String updateProfile(String profile) {
        return "Профиль сотрудник";
    }
}
