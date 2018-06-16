package com.dimlo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("realData")
public class BookDataDbImpl implements Database {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void markRead(int id) {
        Book processed = bookRepository.findById(id).get();
        processed.setReadalready(true);
        bookRepository.save(processed);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void putBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public int getNextId() {
        return 500;
    }

    @Override
    public void addNewBook(Book book) {
        bookRepository.save(book);
    }
}
