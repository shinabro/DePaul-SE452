package edu.depaul.cdm.se.sampleproject.book.spring.nosql.document;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BooksRepository extends MongoRepository<Books, Long> {
}
