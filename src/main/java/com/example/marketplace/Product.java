package com.example.marketplace;

public class Product {
    private String name;
    private double price;
    private final int id;


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        id = hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                " name = " + name + " , id = " + id;
    }
}
