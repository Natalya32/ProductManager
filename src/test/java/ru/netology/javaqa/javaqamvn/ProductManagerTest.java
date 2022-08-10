package ru.netology.javaqa.javaqamvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book prod1 = new Book(24, "Rings", 111, "Tolkin");
    Smartphone prod2 = new Smartphone(222, "Iphone", 111111, "Apple");
    Smartphone prod3 = new Smartphone(123, "Iphone", 112233, "AppleNew");

    @Test
    public void shouldAdd() {
        Product[] prods = {prod1, prod2};
        manager.add(prod1);
        manager.add(prod2);
        Product[] actual = repo.getProds();
        Assertions.assertArrayEquals(prods, actual);
    }

    @Test
    public void shouldSearchByWhenMoreOneMatch() {

        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        Product[] prod = {prod2, prod3};
        Product[] actual = manager.searchBy("Iphone");
        Assertions.assertArrayEquals(prod, actual);
    }

    @Test
    public void shouldSearchByWhenOneMatch() {

        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        Product[] prod = {prod1};
        Product[] actual = manager.searchBy("Rings");
        Assertions.assertArrayEquals(prod, actual);
    }

    @Test
    public void shouldSearchByWhenNoMatch() {

        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        Product[] prod = new Product[0];
        Product[] actual = manager.searchBy("Vape");
        Assertions.assertArrayEquals(prod, actual);
    }

    @Test
    public void shouldRemoveById() {

        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);

        Product[] prod = {prod1, prod3};
        repo.removeById(222);

        Product[] actual = repo.getProds();
        Assertions.assertArrayEquals(prod, actual);
    }
}
