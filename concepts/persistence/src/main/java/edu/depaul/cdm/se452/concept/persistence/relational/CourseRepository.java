package edu.depaul.cdm.se452.concept.persistence.relational;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * For Pagination and Other JPA functionality beyond base CRUD services
 * @see https://docs.spring.io/spring-data/data-jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 */
public interface CourseRepository extends JpaRepository<Course, Long>  {
}
