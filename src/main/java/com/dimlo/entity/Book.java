package com.dimlo.entity;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Indexed
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    //GenerationType.SEQUENCE - need to create table hibernate_sequence in test schema
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Size(min=0, max=85)
    @Field
    private String title;
    @Size(min=0, max=85)
    @Field
    private String description;
    @Size(min=0, max=85)
    @Field
    private String author;
    @Size(min=0, max=20)
    @Field
    private String isbn; //not checkin cyrillic etc
    @Min(Integer.MIN_VALUE)
    @Max(3000)
    @Field
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

    public Integer getPrintyear() {
        return printyear;
    }

    public void setPrintyear(Integer printyear) {
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
