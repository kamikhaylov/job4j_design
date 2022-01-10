package ru.job4j.block04.lsp.product.repositories;

import ru.job4j.block04.lsp.product.Food;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Repository {
    private List<Food> foods;

    public Shop() {
        this.foods = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        return accept(food) && foods.add(applyDiscount(food));
    }

    @Override
    public boolean accept(Food food) {
        return getPercentLifeExpired(food) >= 25;
    }

    public Food applyDiscount(Food food) {
        double percent = getPercentLifeExpired(food);
        if (75 <= percent && percent <= 100) {
            food.setPrice(food.getPrice() - food.getDiscount());
        }
        return food;
    }

    public List<Food> findAll() {
        return (List) ((ArrayList<Food>) foods).clone();
    }
}
