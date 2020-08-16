package edu.depaul.cdm.se452.concept.model;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();
    public Student update(Student student);
  
    public Student findById(String studentId);

    public Student findByStudentId(String studentId);
    
    public void deleteById(String studentId);
}