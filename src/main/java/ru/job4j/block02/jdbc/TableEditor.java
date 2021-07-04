package ru.job4j.block02.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private final Properties properties;
    private Connection connection;

    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

    public void load(InputStream io) {
        try {
            this.properties.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException, IOException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException, IOException {
        ClassLoader loader = TableEditor.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("ru/job4j/block02/jdbc/app.properties")) {
            load(io);
        }
        Class.forName(getValue("driver_class"));
        String url = getValue("url");
        String login = getValue("username");
        String password = getValue("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        executeSQL(String.format(
                "create table if not exists " + tableName + "(%s, %s);",
                "id serial primary key",
                "name varchar(255)"
        ));
    }

    public void dropTable(String tableName) throws SQLException {
        executeSQL(
                "drop table " + tableName + ";"
        );
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        executeSQL(
                "alter table " + tableName + " "
                + "add " + columnName + " " + type
        );
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        executeSQL(
                "alter table " + tableName + " "
                + "drop column " + columnName
        );
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        executeSQL(
                "alter table " + tableName + " "
                + "rename column " + columnName + " to " + newColumnName
        );
    }

    private void executeSQL(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor table = new TableEditor(new Properties());
        table.createTable("test3");
        table.addColumn("test3", "size", "int");
        table.dropColumn("test3", "name");
        table.renameColumn("test3", "size", "length");
        System.out.println(table.getScheme("test3"));
        table.dropTable("test3");
        System.out.println(table.getScheme("test3"));
    }
}