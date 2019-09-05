package com.bookmarket.model;

public class Author {
    private final int authorId;
    private final String name;

    public Author(int authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }
}
