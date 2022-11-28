package ru.netology.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductsManagerTest {
    ProductRepository repository;
    ProductsManager manager;

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

        repository = Mockito.mock(ProductRepository.class);
        Product[] items = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        doReturn(items).when(repository).findAll();

        manager = new ProductsManager(repository);
    }

    @Test
    void testSearchByFounded() {

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("и");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchByFoundedMoreThenOne() {

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Война");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchByNotFounded() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Гарри Поттер");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testAdd() {

        Product newProduct = new Book(7, "Отцы и дети", 2500, "Тургенев");
        manager.add(newProduct);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3, newProduct};
        doReturn(expected).when(repository).findAll();
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

}