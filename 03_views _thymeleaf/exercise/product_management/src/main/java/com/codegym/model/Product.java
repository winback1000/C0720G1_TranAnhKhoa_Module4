package com.codegym.model;

public class Product {
    int id;
    String name;
    String manufacturer;
    double price;
    int stock;
    static int productNum = 0;
    public Product() {
        productNum++;
        this.id = productNum;
    }

    public Product(String name, String manufacturer, double price, int stock) {
        productNum++;
        this.id = productNum;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
