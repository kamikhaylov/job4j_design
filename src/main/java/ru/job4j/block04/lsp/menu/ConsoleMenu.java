package ru.job4j.block04.lsp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConsoleMenu implements Action {
    private String name;
    private List<ConsoleMenu> childs;
    private Action action;
    private int level;

    public ConsoleMenu(String name, Action action) {
        this.name = name;
        this.childs = new ArrayList<>();
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public List<ConsoleMenu> getChilds() {
        return childs;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public String execute() {
        return action.execute();
    }

    public boolean addChild(String parentName, String childName, Action action) {
        if (getName().equals(parentName)) {
            return childs.add(new ConsoleMenu(childName, action));
        } else if (!childs.isEmpty()) {
            for (ConsoleMenu child : childs) {
                return child.addChild(parentName, childName, action);
            }
        }
        return false;
    }

    public String outputChilds(int level) {
        String prefix = "";
        String rsl = new String();
        if (level > 0) {
            prefix += "--- ";
        }
        for (ConsoleMenu child : childs) {
            rsl += "--- " + prefix + child.getName() + System.lineSeparator();
            if (!child.getChilds().isEmpty()) {
                rsl += prefix + child.outputChilds(++level);
            }
        }
        return rsl;
    }

    public Action getActionChild(String itemName) {
        Action rsl = new SimpleAction("Нет действия");
        for (ConsoleMenu child : childs) {
            if (itemName.equals(child.getName())) {
                rsl = child.getAction();
            } else if (!child.getChilds().isEmpty()) {
                rsl = child.getActionChild(itemName);
                if (!rsl.execute().equals("Нет действия")) {
                    break;
                }
            }
        }
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConsoleMenu that = (ConsoleMenu) o;
        return Objects.equals(name, that.name)
                && Objects.equals(action, that.action)
                && Objects.equals(childs, that.childs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, action, childs);
    }
}