package com.ewcode.ewcomerce.domain;

public class Product {

    private final String title;
    private final String description;
    private final String owner;
    private Double price;
    private Category category;

    public Product(String title, String description, Double price, Category category, String owner) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.owner = owner;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public Double price() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Category category() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String owner() {
        return owner;
    }
}
