package edu.depaul.cdm.se452.concept.model;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findByStudentId(String studentId);
}
