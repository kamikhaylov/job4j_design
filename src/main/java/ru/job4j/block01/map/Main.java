package ru.job4j.block01.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Name", 1, new GregorianCalendar(1990, 1, 1));
        User user2 = new User("Name", 1, new GregorianCalendar(1990, 1, 1));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (User user : map.keySet()) {
            System.out.println(user);
        }
    }
}