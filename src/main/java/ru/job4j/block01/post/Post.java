package ru.job4j.block01.post;

/*
Требуется написать работающий код, решающий задачу, и приложить
инструкцию, как код собрать и запустить.
Также надо написать unittest-ы.
Задачу реализовать на Java (достаточно как консольное JAVA приложение).
Код выложить на любой репозиторий (GitHub, GitLab)

Имеется n пользователей, каждому из них соответствует список email-ов
(всего у всех пользователей m email-ов).
Например:
user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru
user2 ->foo@gmail.com,ups@pisem.net
user3 ->xyz@pisem.net,vasya@pupkin.com
user4 ->ups@pisem.net,aaa@bbb.ru
user5 ->xyz@pisem.net

Считается, что если у двух пользователей есть общий email, значит это
один и тот же пользователь. Требуется построить
и реализовать алгоритм, выполняющий слияние пользователей. На выходе
должен быть список пользователей с их email-ами (такой же как на
входе).
В качестве имени объединенного пользователя можно брать любое из
исходных имен. Список email-ов пользователя должен содержать только
уникальные email-ы.
Параметры n и m произвольные, длина конкретного списка email-ов никак
не ограничена.
Требуется, чтобы асимптотическое время работы полученного решения было
линейным, или близким к линейному.

Возможный ответ на задачу в указанном примере:
user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru
user3 ->xyz@pisem.net,vasya@pupkin.com

Для сборки проекта использовать Maven.
Тестирование выполняется на Junit v.4.13.1.
*/

import java.util.*;

public class Post {
    private final Map<String, Set<String>> rsl;
    private final Map<String, String> mapMails;

    public Post() {
        this.rsl = new HashMap<>();
        this.mapMails = new HashMap<>();
    }

    public Map<String, Set<String>> mergingUsers(Map<String, Set<String>> users) {
        addPostInMap(users);
        addUniqueUsers();
        return rsl;
    }

    private void addPostInMap(Map<String, Set<String>> users) {
        boolean duplicate = false;
        String userDuplicate = "";
        for (String user : users.keySet()) {
            Set<String> posts = users.get(user);
            for (String post : posts) {
                if (mapMails.containsKey(post)) {
                    duplicate = true;
                    userDuplicate = mapMails.get(post);
                    break;
                }
            }
            if (duplicate) {
                for (String post : posts) {
                    mapMails.put(post, userDuplicate);
                }
                duplicate = false;
            } else {
                for (String post : posts) {
                    mapMails.put(post, user);
                }
            }
        }
    }

    private void addUniqueUsers() {
        for (String post : mapMails.keySet()) {
            String postAdd = mapMails.get(post);
            if (!rsl.containsKey(mapMails.get(post))) {
                rsl.put(postAdd, new HashSet<>());
            }
            rsl.get(postAdd).add(post);
        }
    }
}
