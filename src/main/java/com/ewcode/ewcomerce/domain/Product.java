package com.ewcode.ewcomerce.domain;

public class Product {

    private String title;
    private String description;
    private Double price;
    private Category category;
    private String owner;
    public Product(String title, String description, Double price, Category category, String owner) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void category(Category category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }
}
