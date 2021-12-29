package ru.job4j.block04.tdd;

import java.util.Objects;

public class Ticket3D implements Ticket {
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket3D ticket3D = (Ticket3D) o;
        return id == ticket3D.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
