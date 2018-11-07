package edu.depaul.cdm.se.sampleproject.book.data.nosql;

import java.util.Random;

public class Review {
    private long id;
    private String review;
    private String isbn;

    public Review() {
        id = new Random().nextLong();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
