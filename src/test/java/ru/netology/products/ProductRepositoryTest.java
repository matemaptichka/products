package ru.netology.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository;

    Book book1, book2, book3;
    Smartphone smartphone1, smartphone2, smartphone3;

    @BeforeEach
    void create() {
        book1 = new Book(1, "Война и мир", 500, "Толстой");
        book2 = new Book(2, "Преступление и наказание", 1000, "Достоевский");
        book3 = new Book(3, "Тихий Дон", 700, "Шолохов");

        smartphone1 = new Smartphone(4, "Smart-1", 10000, "Xiaomi");
        smartphone2 = new Smartphone(5, "iPhone 13", 50000, "Apple");
        smartphone3 = new Smartphone(6, "T-13", 25000, "Samsung");

        Product[] items = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        repository = new ProductRepository(items);
    }

    @Test
    void testAdd() {

        Product newProduct = new Book(7, "Отцы и дети", 2500, "Тургенев");
        repository.add(newProduct);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3, newProduct};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testDelete() {

        repository.delete(4);
        Product[] expected = {book1, book2, book3, smartphone2, smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

}