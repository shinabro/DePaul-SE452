package edu.depaul.cdm.se.sampleproject.book.spring.nosql.document;

import edu.depaul.cdm.se.sampleproject.book.IBook;

import java.io.Serializable;

public class Books implements Serializable, IBook {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer version;

    private String title;

    private String author;

    private String isbn;

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getisbn() { return isbn; }
    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder retval = new StringBuilder();
        retval.append("Book{");
        retval.append("id=");
        retval.append(id);
        retval.append(", title=");
        retval.append(title);

        return retval.toString();

    }
}
