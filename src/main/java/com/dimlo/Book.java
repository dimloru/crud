package com.dimlo;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    //GenerationType.SEQUENCE - need to create table hibernate_sequence in test schema
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    private String title;
    private String description;
    private String author;
    private String isbn;
    private Integer printyear;
    private Boolean readalready;


    public Book(int id, String title, String description, String author, String isbn, int printyear, boolean readalready) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.printyear = printyear;
        this.readalready = readalready;
    }

    public Book(String title, String description, String author, String isbn, Integer printyear, Boolean readalready) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.printyear = printyear;
        this.readalready = readalready;
    }

    public Book() {}

    public Book(int id) {
        this.id = id;
    }

    public Book(Integer printyear, Boolean readalready) {
        this.printyear = printyear;
        this.readalready = readalready;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getPrintyear() {
        return printyear;
    }

    public void setPrintyear(int printyear) {
        this.printyear = printyear;
    }

    public boolean getReadalready() {
        return readalready;
    }

    public void setReadalready(boolean readalready) {
        this.readalready = readalready;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", printyear=" + printyear +
                ", readalready=" + readalready +
                '}';
    }
}
