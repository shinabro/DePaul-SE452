package edu.depaul.cdm.se452.concept.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
  name = "datasource", 
  havingValue = "mock")
public class MockStudentService implements IStudentService {
    private static List<Student> STUDENTS = new ArrayList<Student>();

    static {
        Student student = new Student();
        student.setName("Sheena Wyre");
        student.setEmail("swyre0@un.org");
        student.setStudentId("MOCK1");
        STUDENTS.add(student);

        student = new Student();
        student.setName("Dilly Caffery");
        student.setEmail("dcaffery1@blogspot.com");
        student.setStudentId("MOCK2");
        STUDENTS.add(student);

    }

    @Override
    public List<Student> findAll() {
        return STUDENTS;
    }

    public Student add(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student findById(String studentId) {
        for (Student student : STUDENTS  ) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void deleteById(String studentId) {
        STUDENTS.remove(findById(studentId));
    }

    
}