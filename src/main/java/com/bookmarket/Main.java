package com.bookmarket;

import com.bookmarket.dao.BookmarketDao;
import com.bookmarket.dao.BookmarketDaoImpl;
import com.bookmarket.model.Author;
import com.bookmarket.model.Book;
import com.bookmarket.model.Publisher;
import com.bookmarket.util.DBUtil;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookmarketDao bookmarket = new BookmarketDaoImpl(DBUtil.getConnection());
        List<Book> books = bookmarket.getAllBookByAuthor(new Author(1, "Gogo"));
        for (Book b : books) {
            System.out.println(b.getTitle());
        }
        System.out.println("=====================");
        List<Book> books2 = bookmarket.getAllBookByPublisher(new Publisher(2, "BookMK", "www.bookmx.com"));
        for (Book b2 : books2) {
            System.out.println(b2.getTitle());
        }

        System.out.println("=====================");
        List<Book> books3 = bookmarket.getAllBookByPublisher(new Publisher(1,"AX","www.google.com"));
        for (Book b3 : books3) {
            System.out.println(b3.getTitle());
        }

        System.out.println("=====================");
        bookmarket.updateBookPrice(new Publisher(1,"AX","www.bookmx.com"),new Book("978-3-16-148410-0","House",123,2),300);
        List<Book> books5 = bookmarket.getAllBookByAuthor(new Author(1, "Pushkin"));
        for (Book b2 : books5) {
            System.out.println(b2.getTitle()+ " price - "+ b2.getPrice());
        }
    }
}
