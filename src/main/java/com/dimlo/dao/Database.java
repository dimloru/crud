package com.dimlo.dao;

import com.dimlo.entity.Book;

import java.util.Collection;

public interface Database {
//    List<Record> getData();

    Collection<Book> getAllBooks();

    void deleteBook(int id);

    void markRead(int id);

    Book getBookById(int id);

    void putBook(Book book);

    int getNextId();
}
