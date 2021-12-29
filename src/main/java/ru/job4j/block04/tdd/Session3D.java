package ru.job4j.block04.tdd;

import java.util.Objects;

public class Session3D implements Session {
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session3D session3D = (Session3D) o;
        return id == session3D.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
