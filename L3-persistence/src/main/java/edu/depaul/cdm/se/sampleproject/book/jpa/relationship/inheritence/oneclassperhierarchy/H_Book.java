package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.inheritence.oneclassperhierarchy;

import javax.persistence.Entity;

@Entity
public class H_Book extends H_Publication{
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
