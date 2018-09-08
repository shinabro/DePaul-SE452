package edu.depaul.cdm.se.sampleproject.book.jdbc;

import edu.depaul.cdm.se.sampleproject.book.IBook;

public class Book implements IBook {

    private String author;
    private long id;
    private String isbn;
    private String title;
    private int version;

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "author=" + author + ", id=" + id + ", isbn=" + isbn + ", title=" + title + ", version=" + version + '}';
    }

}
