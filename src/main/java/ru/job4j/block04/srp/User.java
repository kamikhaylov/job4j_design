package ru.job4j.block04.srp;

import java.util.ArrayList;
import java.util.List;

public class User implements Authorize {
    private static User user;
    private int id;
    private String login;
    private String mail;

    private User(int id, String login, String mail) {
        this.id = id;
        this.login = login;
        this.mail = mail;
    }

    public static User getInstance(int id, String login, String mail) {
        if (user == null) {
            user = new User(id, login, mail);
        }
        return user;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public void loginAccount() {
        System.out.println("Введите логин");
    }

    @Override
    public List<String> loginHistory() {
        return new ArrayList<>();
    }

    public List<String> mails() {
        return new ArrayList<>();
    }

    public List<String> logins() {
        return new ArrayList<>();
    }
}
