package com.bookmarket.dao;

import com.bookmarket.model.Author;
import com.bookmarket.model.Book;
import com.bookmarket.model.Publisher;

import java.util.List;

public interface BookmarketDao {
    List<Book> getAllBookByPublisher(Publisher publisher);
    List<Book> getAllBookByAuthor(Author author);
    void updateBookPrice(Publisher publisher, Book book, int newPrice);
}
