package ru.job4j.block04.ocp;

public class FootballPlayer implements AttackingPlayer {
    @Override
    public void attack() {
        System.out.println("Разбег + удар ногой");
    }
}
