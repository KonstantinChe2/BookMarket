package com.bookmarket.dao;

import com.bookmarket.executor.Executor;
import com.bookmarket.executor.ResultHandler;
import com.bookmarket.model.Author;
import com.bookmarket.model.Book;
import com.bookmarket.model.Publisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookmarketDaoImpl implements BookmarketDao {
    private Executor executor;

    public BookmarketDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }

    @Override
    public List<Book> getAllBookByPublisher(Publisher publisher) {
        List<Book> books = new ArrayList<>();
        try {
            return executor.execQuery("SELECT * FROM books WHERE publisher_id in(select publisher_id from publishers where name = '" + publisher.getName() + "')",
                    new ResultHandler<List<Book>>() {
                        @Override
                        public List<Book> handle(ResultSet resultSet) throws SQLException {
                            while (resultSet.next()) {
                                Book book = new Book(resultSet.getString("isbn"), resultSet.getString("title"), resultSet.getInt("price"), resultSet.getInt("publisher_id"));
                                books.add(book);
                            }
                            return books;
                        }
                    });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> getAllBookByAuthor(Author author) {
        List<Book> books = new ArrayList<>();
        try {
            return executor.execQuery("SELECT * FROM books WHERE isbn in(select isbn from books_authors where authorid in (select authorid from authors where name = '" + author.getName() + "'))",
                    new ResultHandler<List<Book>>() {
                        @Override
                        public List<Book> handle(ResultSet resultSet) throws SQLException {
                            while (resultSet.next()) {
                                Book book = new Book(resultSet.getString("isbn"), resultSet.getString("title"), resultSet.getInt("price"), resultSet.getInt("publisher_id"));
                                books.add(book);
                            }
                            return books;
                        }
                    });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void updateBookPrice(Publisher publisher, Book book, int newPrice) {
        try {
            executor.execUpdate("UPDATE books SET price = " + newPrice + " where title = '"+book.getTitle()+"' AND publisher_id in (select publisher_id from publishers where name = '"+publisher.getName()+"') ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
