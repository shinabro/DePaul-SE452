package edu.depaul.cdm.se.sampleproject.book.spring.nosql.graph;

import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long> {
}
