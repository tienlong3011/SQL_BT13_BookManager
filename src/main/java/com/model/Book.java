package com.model;

public class Book {
    private int id;
    private String nameBook;
    private double price;
    private String description;
    private Category category;

    public Book() {
    }

    public Book(int id, String nameBook, double price, String description, Category category) {
        this.id = id;
        this.nameBook = nameBook;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Book(String nameBook, double price, String description, Category category) {
        this.nameBook = nameBook;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
