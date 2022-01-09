package ru.job4j.block04.lsp.product;

import ru.job4j.block04.lsp.product.repositories.Shop;
import ru.job4j.block04.lsp.product.repositories.Trash;
import ru.job4j.block04.lsp.product.repositories.Warehouse;

import java.util.Calendar;

public class ControllQuality {
    private RouteStrategy routeStrategy;
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    public ControllQuality() {
        this.routeStrategy = new RouteStrategy();
        this.warehouse = new Warehouse();
        this.shop = new Shop();
        this.trash = new Trash();
    }

    public RouteStrategy getRouteStrategy() {
        return routeStrategy;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Shop getShop() {
        return shop;
    }

    public Trash getTrash() {
        return trash;
    }

    public void control(Food food) {
        if (Calendar.getInstance().getTimeInMillis() >= food.getExpiryDate().getTimeInMillis()) {
            routeStrategy.route(trash);
        } else if (getProductLifeTime(food) < getShelfLife25percent(food)) {
            routeStrategy.route(warehouse);
        } else if (getProductLifeTime(food) >= getShelfLife25percent(food)
                    && getProductLifeTime(food) <= getShelfLife75percent(food)) {
            routeStrategy.route(shop);
        } else if (getProductLifeTime(food) > getShelfLife75percent(food)) {
            food.setPrice(food.getPrice() - food.getDiscount());
            routeStrategy.route(shop);
        }
        routeStrategy.getRepositories().add(food);
    }

    private long getProductLifeTime(Food food) {
        return Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
    }

    private long getMaxShelfLife(Food food) {
        return food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
    }

    private long getShelfLife25percent(Food food) {
        return getMaxShelfLife(food) / 100 * 25;
    }

    private long getShelfLife75percent(Food food) {
        return getMaxShelfLife(food) / 100 * 75;
    }
}
