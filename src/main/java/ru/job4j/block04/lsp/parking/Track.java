package ru.job4j.block04.lsp.parking;

import java.util.Objects;

public class Track implements Vehicle {
    private String name;
    private int size;

    public Track(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Track track = (Track) o;
        return size == track.size && Objects.equals(name, track.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}
