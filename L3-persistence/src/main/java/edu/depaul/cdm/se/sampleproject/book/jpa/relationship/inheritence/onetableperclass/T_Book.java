package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.inheritence.onetableperclass;

import javax.persistence.Entity;

@Entity
public class T_Book extends T_Publication {
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
