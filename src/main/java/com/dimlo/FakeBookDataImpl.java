//package com.dimlo;
//
//
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
////@Qualifier("fakeBookData")
//public class FakeBookDataImpl  {
//
//    private Map<Integer, Book> books = new TreeMap() {
//        {
//            put(4, new Book(4, "English Advanced", "Studens book", "Enlish File", "jkfdsa3290", 2017, false));
//            put(1, new Book(1, "The Neon Lawyer", "detective", "Victor Methos", "07895ml0", 2018, false));
//            put(5, new Book(5, "7 habits", "Self-study", "Stephen R. Covey", "j7bgml", 2012, true));
//            put(7, new Book(7, "The Outsider", "thriller", "Stephen King", "0jklg438", 2018, false));
//            put(13, new Book(13, "Romeo and Juliette", "Nolvel", "Shakespere", "111111", 1985, true));
//            put(254, new Book(254, "Game of Thrones", "Novel", "J. Martin", "jkfdsa3290", 2017, true));
//        }
//    };
//
//    @Override
//    public Iterable<Book> getAllBooks() {
//        return books.values();
//    }
//
//    @Override
//    public void deleteBook(int id) {
//        books.remove(id);
//
//    }
//
//    @Override
//    public void markRead(int id) {
//        books.get(id).setReadalready(true);
//    }
//
//    @Override
//    public Book getBookById(int id) {
//        return books.get(id);
//    }
//
//    @Override
//    public void putBook(Book book) {
//        books.put(book.getId(), book);
//    }
//
//    @Override
//    public int getNextId() {
//        return books.keySet()
//                .stream()
//                .max(Comparator.naturalOrder())
//                .orElse(0) + 1;
//    }
//}
