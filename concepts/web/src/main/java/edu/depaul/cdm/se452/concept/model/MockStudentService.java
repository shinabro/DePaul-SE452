package edu.depaul.cdm.se452.concept.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "mock")
public class MockStudentService implements IStudentService {
    private static List<Student> STUDENTS = new ArrayList<Student>();

    static {
        Stream.of("Sheena Wyre", "Dilly Caffery", "Marysa Alyonov", "Julie Venturoli", "SFrieda Liddiatt")
                .forEach(name -> {
                    Student student = new Student();
                    student.setName(name);
                    StringTokenizer tokenizer = new StringTokenizer(name, " ");
                    student.setId(UUID.randomUUID());
                    student.setStudentId(tokenizer.nextToken().toUpperCase());
                    student.setEmail(tokenizer.nextToken().toLowerCase() + "@mockup.com");
                    STUDENTS.add(student);

                });
    }

    @Override
    public List<Student> findAll() {
        return STUDENTS;
    }

    @Override
    public Student update(Student student) {

        if (student.getId() == null) {
            student.setId(UUID.randomUUID());
            student.setStudentId(student.getName().toLowerCase().substring(0,6)+'1');
            STUDENTS.add(student);
        } else {
            Student originalStudent = findById(student.getId().toString());
            STUDENTS.remove(originalStudent);
            STUDENTS.add(student);
        }


        return student;
    }

    @Override
    public Student findById(String studentId) {
        for (Student student : STUDENTS) {
            if (student.getId().toString().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public Student findByStudentId(String studentId) {
        for (Student student : STUDENTS) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String studentId) {
        STUDENTS.remove(findById(studentId));
    }

}