package ru.job4j.block04.lsp.product.repositories;

import ru.job4j.block04.lsp.product.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Repositories {
    private List<Food> foods;

    public Trash() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    public List<Food> findAll() {
        return foods;
    }
}
