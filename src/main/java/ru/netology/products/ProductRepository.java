package ru.netology.products;

public class ProductRepository {

    Product[] products;

    public ProductRepository(Product[] products) {
        this.products = products;
    }

    public Product[] findAll() {
        return products;
    }

    public void add(Product product) {

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    public void delete(int id) {

        Product[] tmp = new Product[products.length - 1];

        int index = -1;
        for (int i = 0; i < products.length; i++) {

            if (products[i].id != id) {
                index++;
                tmp[index] = products[i];
            }

        }

        products = tmp;

    }

}
