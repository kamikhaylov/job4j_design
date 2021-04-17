package ru.job4j.block01.post;
/*
В тесте используется LinkedHashSet с целью вывода постоянного результата тестирования.
Т.к. по заданию в качестве имени объединенного пользователя можно брать любое из
исходных имен.
*/

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.*;

public class PostTest {
    @Test
    public void mergingUsersTest() {
        Post post = new Post();

        Set<String> posts1 = new LinkedHashSet<>();
        posts1.add("xxx@ya.ru");
        posts1.add("foo@gmail.com");
        posts1.add("lol@mail.ru");
        Set<String> posts2 = new LinkedHashSet<>();
        posts2.add("foo@gmail.com");
        posts2.add("ups@pisem.net");
        Set<String> posts3 = new LinkedHashSet<>();
        posts3.add("xyz@pisem.net");
        posts3.add("vasya@pupkin.com");
        Set<String> posts4 = new LinkedHashSet<>();
        posts4.add("ups@pisem.net");
        posts4.add("aaa@bbb.ru");
        Set<String> posts5 = new LinkedHashSet<>();
        posts5.add("xyz@pisem.net");

        Map<String, Set<String>> users = new LinkedHashMap<>();
        users.put("User1", posts1);
        users.put("User2", posts2);
        users.put("User3", posts3);
        users.put("User4", posts4);
        users.put("User5", posts5);

        Map<String, Set<String>> rsl = post.mergingUsers(users);

        Set<String> expPost1 = new LinkedHashSet<>();
        expPost1.add("xxx@ya.ru");
        expPost1.add("foo@gmail.com");
        expPost1.add("lol@mail.ru");
        expPost1.add("ups@pisem.net");
        expPost1.add("aaa@bbb.ru");
        Set<String> expPost2 = new LinkedHashSet<>();
        expPost2.add("xyz@pisem.net");
        expPost2.add("vasya@pupkin.com");

        Map<String, Set<String>> expected = new LinkedHashMap<>();
        expected.put("User1", expPost1);
        expected.put("User3", expPost2);

        assertThat(rsl, is(expected));
    }
}