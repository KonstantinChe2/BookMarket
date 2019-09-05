package com.bookmarket.model;

public class Book {
    private final String isbn;
    private final String title;
    private final int price;
    private final int publisherId;

    public Book(String isbn, String title, int price, int publisherId) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.publisherId = publisherId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getPublisherId() {
        return publisherId;
    }
}
