package edu.depaul.cdm.se452.concept.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class StudentService implements IStudentService {

  @Autowired
  private StudentRepository repository;

  @Override
  public List<Student> findAll() {
    return repository.findAll();
  }

  @Override
  public Student add(Student student) {
    repository.save(student);
    return student;
  }

  @Override
  public Student findById(String studentId) {
    return repository.findByStudentId(studentId).get(0);
  }

  @Override
  public void deleteById(String studentId) {
    List<Student> students = repository.findByStudentId(studentId);
    for (Student student : students) {
      repository.delete(student);
    }
  }

}