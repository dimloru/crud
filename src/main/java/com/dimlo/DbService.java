package com.dimlo;

import com.dimlo.BookDataDbImpl;
import com.dimlo.Database;
import com.dimlo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DbService {

    @Autowired
    @Qualifier("realData")
    private Database database; //= new BookDataDbImpl();

    public Iterable<Book> getAllBooks() {
        return database.getAllBooks();
    }

//    public Iterable<Book> getAllBooksAsList() {
//
//
//    Iterable<Book> allBooks = dbService.getAllBooks();
//    List<Book> allBooksList = new ArrayList<>();
//        allBooks.forEach(allBooksList::add);
//
//
//    }


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

    public Iterable<Book> search(String stitle, String sdesc, String sauthor, String sisbn, String syearfrom, String syearto) {
        Integer yearFrom, yearTo;
        try {
            yearFrom = Integer.parseInt(syearfrom);
        } catch (NumberFormatException e) {
            yearFrom = Integer.MIN_VALUE;

        }try {
            yearTo = Integer.parseInt(syearto);
        } catch (NumberFormatException e) {
            yearTo = Integer.MAX_VALUE;
        }

//        if (stitle != null && stitle.equals("")) stitle = null;
//        if (sdesc != null && sdesc.equals("")) sdesc = null;
//        if (sauthor != null && sauthor.equals("")) sauthor = null;
//        if (sisbn != null && sisbn.equals("")) sisbn = null;

        return database.search(stitle, sdesc, sauthor, sisbn, yearFrom, yearTo);
    }
}
