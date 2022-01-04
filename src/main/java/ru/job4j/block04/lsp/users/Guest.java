package ru.job4j.block04.lsp.users;

public class Guest extends User {
    private String access;

    @Override
    public String hasAccess(String actions) {
        return "Доступ гость";
    }

    @Override
    public String updateProfile(String profile) {
        try {
            throw new Exception("Нет профиля");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Нет профиля";
    }
}
