package ru.job4j.block04.lsp.product;

import ru.job4j.block04.lsp.product.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private List<Repository> repository;

    public ControllQuality(List<Repository> repository) {
        this.repository = repository;
    }

    public void control(Food food) {
        for (Repository rep : repository) {
            rep.add(food);
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Repository r : repository) {
            foods.addAll(r.remove());
        }
        for (Food food : foods) {
            control(food);
        }
    }
}