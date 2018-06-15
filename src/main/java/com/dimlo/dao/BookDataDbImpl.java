package com.dimlo.dao;

import com.dimlo.entity.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//@Qualifier("BookDataDb")
public class BookDataDbImpl { //implements Database {
    public List<Book> getAllBooks() {
        return null;
    }

    public void deleteBook(int id) {

    }

    public void markRead(int id) {

    }

    public Book getBookById(int id) {
        return null;
    }
}
