package com.dimlo.dao;

import com.dimlo.entity.Book;
import com.dimlo.entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

//@Repository
//@Qualifier("BookDataDb")
public class BookDataDbImpl implements Database {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Iterable<Book> getAllBooks() {
        System.out.println("//////////////" + (bookRepository == null));
        return bookRepository.findAll();

    }

    @Override
    public void deleteBook(int id) {

    }

    @Override
    public void markRead(int id) {
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public void putBook(Book book) {

    }

    @Override
    public int getNextId() {
        return 500;
    }
}
