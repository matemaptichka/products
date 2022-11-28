package ru.netology.products;

public class Smartphone extends Product {

    public String manufacturer;

    public Smartphone(int id, String name, float price, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

}
