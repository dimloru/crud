package com.dimlo;

import com.dimlo.BookDataDbImpl;
import com.dimlo.Database;
import com.dimlo.Book;
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
        database.putBook(book);
    }

    public int getNextId() {
        return database.getNextId();
    }

    public void addNewBook(Book book) {
        database.addNewBook(book);
    }
}
