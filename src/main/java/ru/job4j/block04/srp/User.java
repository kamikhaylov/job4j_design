package ru.job4j.block04.srp;

import java.util.ArrayList;
import java.util.List;

public class User implements Authorize {
    private int id;
    private String login;
    private String mail;

    public User(int id, String login, String mail) {
        this.id = id;
        this.login = login;
        this.mail = mail;
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
