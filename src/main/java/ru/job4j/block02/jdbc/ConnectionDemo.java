package ru.job4j.block02.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {

    private final Properties prs = new Properties();

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        ConnectionDemo connectionDemo = new ConnectionDemo();
        ClassLoader loader = ConnectionDemo.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("ru/job4j/block02/jdbc/app.properties")) {
            connectionDemo.load(io);
        }
        Class.forName(connectionDemo.getValue("driver_class"));
        String url = connectionDemo.getValue("url");
        String login = connectionDemo.getValue("username");
        String password = connectionDemo.getValue("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}