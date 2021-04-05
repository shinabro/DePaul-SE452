package edu.depaul.cdm.se452.concept.persistence.relational;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class StudentTest {
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private StudentRepository repository;

    @Test
    void testStudentSaveAndFetch() {
        Student student = new Student();
        student.setName("Daniel");
        entityManager.persist(student);
                 
        Student student2 = repository.findById(student.getId()).get();
         
        assertThat(student.getEmail()).isEqualTo(null);
        assertThat(student).isEqualTo(student2);

        String testEmail = "daniel@depaul.edu"; 
        student2.setEmail(testEmail);
        entityManager.persist(student2);

        Student student3 = repository.findById(student.getId()).get();
        assertThat(student3.getEmail()).isEqualTo(testEmail);

    }

}