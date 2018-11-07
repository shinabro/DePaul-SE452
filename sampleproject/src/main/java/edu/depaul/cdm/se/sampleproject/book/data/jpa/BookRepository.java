package edu.depaul.cdm.se.sampleproject.book.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    /**
     * Find all the book by the isbn, technical there should only be one but just in case
     * @param isbn
     * @return
     */
    public List<Book> findByIsbn(String isbn);
}
