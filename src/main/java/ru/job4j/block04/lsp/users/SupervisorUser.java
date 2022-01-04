package ru.job4j.block04.lsp.users;

public class SupervisorUser extends EmployeeUser {
    private int id;
    private String access;
    private String profile;

    @Override
    public String hasAccess(String actions) {
        return "Доступ сотрудник + Доступ Руководитель";
    }

    @Override
    public String updateProfile(String profile) {
        return "Профиль руководитель + Профиль Руководитель";
    }
}
