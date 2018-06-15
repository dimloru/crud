package com.dimlo.dao;

import com.dimlo.entity.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//@Qualifier("BookDataDb")
public class BookDataDbImpl implements Database {
    @Override
    public List<Book> getAllBooks() {
        return null;
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
}
