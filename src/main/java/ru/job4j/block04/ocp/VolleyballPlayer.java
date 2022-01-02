package ru.job4j.block04.ocp;

public class VolleyballPlayer implements AttackingPlayer {
    @Override
    public void attack() {
        System.out.println("Прыжок в высоту + удар рукой");
    }
}
