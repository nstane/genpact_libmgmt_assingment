package com.genpact.librarymgmt.dto;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String author;
    @ManyToOne(targetEntity = Library.class)
    private Library library;

    public Book() { }
    public Book(String title, String author, Library library) {
        this.title = title;
        this.author = author;
        this.library = library;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
