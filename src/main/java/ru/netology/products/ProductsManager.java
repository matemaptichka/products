package ru.netology.products;

public class ProductsManager {

    ProductRepository repository;

    public ProductsManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {

                Product[] tmp = new Product[result.length + 1];

                if (result.length > 0) {
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                }

                tmp[result.length] = product;
                result = tmp;

            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    public void add(Product product) {
        repository.add(product);
    }

}
