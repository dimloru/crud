package com.dimlo.dao;

import com.dimlo.entity.Book;
import com.dimlo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public Iterable<Book> search(String stitle, String sdesc, String sauthor, String sisbn, Integer yearFrom, Integer yearTo) {

        return StreamSupport.stream(getAllBooks().spliterator(), false)
                .filter(s -> (s.getPrintyear() != null && s.getPrintyear() >= yearFrom && s.getPrintyear() <= yearTo) || s.getPrintyear() == null)
                .filter(s -> stitle == "" || (stitle != null && s.getTitle() != null && stitle.equals(s.getTitle())))
                .filter(s -> sdesc == "" || (sdesc != null && s.getDescription() != null && sdesc.equals(s.getDescription())))
                .filter(s -> sauthor == "" || (sauthor != null && s.getAuthor() != null && sauthor.equals(s.getAuthor())))
                .filter(s -> sisbn == "" || (sisbn != null && s.getIsbn() != null && sisbn.equals(s.getIsbn())))

                .collect(Collectors.toList());
    }
}
