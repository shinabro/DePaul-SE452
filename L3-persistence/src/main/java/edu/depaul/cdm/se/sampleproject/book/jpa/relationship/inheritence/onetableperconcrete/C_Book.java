package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.inheritence.onetableperconcrete;

import javax.persistence.Entity;

@Entity
public class C_Book extends C_Publication {
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
