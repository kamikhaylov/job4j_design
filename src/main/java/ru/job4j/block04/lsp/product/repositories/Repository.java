package ru.job4j.block04.lsp.product.repositories;

import ru.job4j.block04.lsp.product.Food;
import java.util.Calendar;
import java.util.List;

public interface Repository {
    boolean add(Food food);

    boolean accept(Food food);

    default double getPercentLifeExpired(Food food) {
        long currentProductLifeTime =
                Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long maxProductLifeTime =
                food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        return (double) currentProductLifeTime * 100 / maxProductLifeTime;
    }

    List<Food> findAll();

    List<Food> remove();
}