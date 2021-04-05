package edu.depaul.cdm.se452.concept.lombak;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
    @Test
    void testStudentSetter() {
        String studentName = "dave";
        Student student = new Student();
        student.setName("dave");
        assertThat(studentName).isEqualTo(student.getName());
    }
   
}

