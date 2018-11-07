package edu.depaul.cdm.se.sampleproject.book.data.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookReviewRepository extends MongoRepository<Review, Long> {
    /**
     * Find all the comments
     * @param isbn
     * @return
     */
    public List<Review> findByIsbn(String isbn);
}
