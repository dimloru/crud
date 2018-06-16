package com.dimlo.dao;

import com.dimlo.entity.Book;

public interface Database {
//    List<Record> getData();

    Iterable<Book> getAllBooks();

    void deleteBook(int id);

    void markRead(int id);

    Book getBookById(int id);

    void putBook(Book book);

    int getNextId();
}
