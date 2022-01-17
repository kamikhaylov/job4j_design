package ru.job4j.block04.lsp.product.repositories;

import ru.job4j.block04.lsp.product.Food;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Repository {
    private List<Food> foods;
    private Food food;

    public Shop() {
        this.foods = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        return accept(food) && foods.add(this.food);
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        double percent = getPercentLifeExpired(food);
        if (percent >= 25) {
            this.food = food;
            rsl = true;
        }
        if (75 <= percent && percent <= 100) {
            this.food = applyDiscount(food);
        }
        return rsl;
    }

    public Food applyDiscount(Food food) {
        food.setPrice(food.getPrice() - food.getDiscount());
        return food;
    }

    @Override
    public List<Food> findAll() {
        return (List<Food>) ((ArrayList<Food>) foods).clone();
    }

    @Override
    public boolean remove(Food food) {
        return foods.remove(food);
    }
}
