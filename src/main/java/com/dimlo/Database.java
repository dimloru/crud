package com.dimlo;

public interface Database {
//    List<Record> getData();

    Iterable<Book> getAllBooks();

    void deleteBook(int id);

    void markRead(int id);

    Book getBookById(int id);

    void putBook(Book book);

    int getNextId();

    void addNewBook(Book book);

    Iterable<Book> search(String stitle, String sdesc, String sauthor, String sisbn, Integer yearFrom, Integer yearTo);
}
