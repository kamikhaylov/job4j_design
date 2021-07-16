package ru.job4j.block02.jdbc.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            for (String line = rd.readLine(); line != null; line = rd.readLine()) {
                String[] arr =  line.split(";");
                users.add(new User(arr[0], arr[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "insert into spammer(name, email) values (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "name = " + name + ", email = " + email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("data/spammer/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "data/spammer/dump.txt");
        db.save(db.load());
    }
}