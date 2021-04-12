package ru.job4j.block01.analize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analyze {
    public Info diff(List<User> previous, List<User> current) {
        int added = current.size();
        int changed = 0;
        int noChanged = 0;
        Map<Integer, String> users = new HashMap<>();
        for (User user : previous) {
            users.put(user.getId(), user.getName());
        }
        for (User user : current) {
            if (users.containsKey(user.getId())) {
                if (!Objects.equals(user.getName(), users.get(user.getId()))) {
                    changed++;
                } else {
                    noChanged++;
                }
                added--;
            }
        }
        int deleted = previous.size() - changed - noChanged;
        return new Info(added, changed, deleted);
    }
}