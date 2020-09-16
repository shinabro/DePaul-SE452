package edu.depaul.cdm.se452.concept.persistence.relational;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

/**
 * @see https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 */
public interface StudentRepository extends CrudRepository<Student, Long>  {
}
