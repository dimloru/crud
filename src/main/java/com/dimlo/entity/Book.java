package com.dimlo.entity;

public class Book {
    private int id;
    private String title;
    private String description;
    private String author;
    private String isbn;
    private int printYear;
    private boolean readAlready;

    public Book(int id, String title, String description, String author, String isbn, int printYear, boolean readAlready) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.printYear = printYear;
        this.readAlready = readAlready;
    }

    public Book() {}

    public Book(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public boolean isReadAlready() {
        return readAlready;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
    }
}
