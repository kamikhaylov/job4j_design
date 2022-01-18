package ru.job4j.block04.lsp.product.repositories;

import ru.job4j.block04.lsp.product.Food;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Repository {
    private List<Food> foods;

    public Warehouse() {
        this.foods = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        return accept(food) && foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return getPercentLifeExpired(food) < 25;
    }

    @Override
    public List<Food> findAll() {
        return (List<Food>) ((ArrayList<Food>) foods).clone();
    }

    @Override
    public List<Food> remove() {
        List<Food> copyFoods = new ArrayList<>();
        copyFoods.addAll(foods);
        foods.clear();
        return copyFoods;
    }
}
