package ru.job4j.block04.lsp.product;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.block04.lsp.product.repositories.Shop;
import ru.job4j.block04.lsp.product.repositories.Trash;
import ru.job4j.block04.lsp.product.repositories.Warehouse;
import java.util.Calendar;
import java.util.List;

public class ControllQualityTest {
    @Test
    public void thenAddInShop() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(
                shop,
                warehouse,
                trash));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 5,
                10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 5,
                10, 0);
        Food milk = new Food("Milk", expiryDate, createDate, 100, 5);
        List<Food> expected = List.of(milk);
        controllQuality.control(milk);
        assertThat(shop.findAll(), is(expected));
    }

    @Test
    public void thenAddInWarehouse() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(
                shop,
                warehouse,
                trash));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 10,
                10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 2,
                10, 0);
        Food milk = new Food("Milk", expiryDate, createDate, 100, 5);
        List<Food> expected = List.of(milk);
        controllQuality.control(milk);
        assertThat(warehouse.findAll(), is(expected));
    }

    @Test
    public void thenAddInShopAndDiscount() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(
                shop,
                warehouse,
                trash));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 2,
                10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 10,
                10, 0);
        Food milk = new Food("Milk", expiryDate, createDate, 100, 5);
        List<Food> expected = List.of(milk);
        controllQuality.control(milk);
        assertThat(shop.findAll(), is(expected));
    }

    @Test
    public void thenAddInShopAndDiscountWhenDiscount() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(
                shop,
                warehouse,
                trash));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 2,
                10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 10,
                10, 0);
        Food milk = new Food("Milk", expiryDate, createDate, 100, 5);
        int expected = milk.getPrice() - milk.getDiscount();
        controllQuality.control(milk);
        List<Food> foodsShop = shop.findAll();
        Food food = foodsShop.get(0);
        assertThat(food.getPrice(), is(expected));
    }

    @Test
    public void thenAddInTrash() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(
                shop,
                warehouse,
                trash));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) - 1,
                10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 10,
                10, 0);
        Food milk = new Food("Milk", expiryDate, createDate, 100, 5);
        List<Food> expected = List.of(milk);
        controllQuality.control(milk);
        assertThat(trash.findAll(), is(expected));
    }
}