package ru.netology.products;

public class Book extends Product {

    public String author;

    public Book(int id, String name, float price, String author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
    }

}
