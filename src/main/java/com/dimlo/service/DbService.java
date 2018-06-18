package com.dimlo.service;

import com.dimlo.dao.Database;
import com.dimlo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    @Qualifier("realData")
    private Database database; //= new BookDataDbImpl();

    public Iterable<Book> getAllBooks() {
        return database.getAllBooks();
    }

    public void deleteBook(int id) {
        database.deleteBook(id);
    }

    public void markRead(int id) {
        database.markRead(id);
    }

    public Book getBookById(int id) {
        return database.getBookById(id);
    }

    public void putBook(Book book) {
        // 2 different methods just in case
        database.putBook(book);
    }

    public void addNewBook(Book book) {
        // 2 different methods just in case
        database.addNewBook(book);
    }

    public Iterable<Book> search(String stitle, String sdesc, String sauthor, String sisbn, String syearfrom, String syearto) {

        Integer yearFrom, yearTo;

        try {
            yearFrom = Integer.parseInt(syearfrom);
        } catch (NumberFormatException e) {
            yearFrom = Integer.MIN_VALUE;
        }

        try {
            yearTo = Integer.parseInt(syearto);
        } catch (NumberFormatException e) {
            yearTo = Integer.MAX_VALUE;
        }

        return database.search(stitle.trim(), sdesc.trim(), sauthor.trim(), sisbn.trim(), yearFrom, yearTo);
    }
}
