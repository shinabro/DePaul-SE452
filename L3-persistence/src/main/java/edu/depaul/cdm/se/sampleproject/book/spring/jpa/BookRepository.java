package edu.depaul.cdm.se.sampleproject.book.spring.jpa;

import edu.depaul.cdm.se.sampleproject.book.jpa.single.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
