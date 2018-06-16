package com.dimlo.service;

import com.dimlo.dao.BookDataDbImpl;
import com.dimlo.dao.Database;
import com.dimlo.dao.FakeBookDataImpl;
import com.dimlo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
//    @Qualifier("fakeBookData")
    private Database database = new BookDataDbImpl();

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
        database.putBook(book);
    }

    public int getNextId() {
        return database.getNextId();
    }
}
