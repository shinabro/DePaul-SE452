package edu.depaul.cdm.se.sampleproject.book.spring;

import edu.depaul.cdm.se.sampleproject.book.jpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
