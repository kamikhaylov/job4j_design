package ru.job4j.block02.jdbc.city;

import ru.job4j.block02.jdbc.TableEditor;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PrepareStatementDemo {
    private final Properties properties;
    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        this.properties = new Properties();
        initConnection();
    }

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

    private void initConnection() throws Exception {
        ClassLoader loader = TableEditor.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("ru/job4j/block02/jdbc/app.properties")) {
            load(io);
        }
        Class.forName(getValue("driver_class"));
        String url = getValue("url");
        String login = getValue("username");
        String password = getValue("password");
        this.connection = DriverManager.getConnection(url, login, password);
    }

    public void insert(City city) {
        try (PreparedStatement statement =
                connection.prepareStatement("insert into cities(name, population) values (?, ?)")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("update cities "
                             + "set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                connection.prepareStatement("delete from cities where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public void truncateTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(
                    "truncate table " + tableName + ";"
            );
        }
    }

    public static void main(String[] args) throws Exception {
        PrepareStatementDemo demo = new PrepareStatementDemo();
        demo.insert(new City(11, "City_1", 1_000_000));
        demo.insert(new City(12, "City_1", 1_000_000));
        demo.update(new City(12, "City_1", 2_000_000));
        demo.delete(11);
        for (City city : demo.findAll()) {
            System.out.println(city.toString());
        }
    }
}
