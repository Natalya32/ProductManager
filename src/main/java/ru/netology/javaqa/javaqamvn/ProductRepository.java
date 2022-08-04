package ru.netology.javaqa.javaqamvn;

public class ProductRepository {
    private Product[] prods = new Product[0];

    public void save(Product prod) {
        Product[] tmp = new Product[prods.length + 1];
        for (int i = 0; i < prods.length; i++) {
            tmp[i] = prods[i];
        }
        tmp[tmp.length - 1] = prod;
        prods = tmp;
    }

    public Product[] getProds() {
        return prods;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[prods.length - 1];
        int copyToIndex = 0;
        for (Product prod : prods) {
            if (prod.getId() != id) {
                tmp[copyToIndex] = prod;
                copyToIndex++;
            }
        }
        prods = tmp;
    }
}
