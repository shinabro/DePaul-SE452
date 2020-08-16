package edu.depaul.cdm.se452.concept.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.concept.model.IStudentService;
import edu.depaul.cdm.se452.concept.model.Student;

@RestController
@RequestMapping("students")
public class StudentRestController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
      return studentService.update(student);
    }
  
    @GetMapping("/{id}")
    public Student find(@PathVariable String id) {
  
      return studentService.findById(id);
    }
  
    @PutMapping("/{id}")
    public Student update(@RequestBody Student updateStudent, @PathVariable String id) {  
      Student student = studentService.findById(id);
      student.setAdmittedDate(updatedValue(updateStudent.getAdmittedDate(), student.getAdmittedDate()));
      student.setEmail(updatedValue(updateStudent.getEmail(), student.getEmail()));
      student.setName(updatedValue(updateStudent.getName(), student.getName()));
      return student;
    }
  
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
      studentService.deleteById(id);
    }
    
    private String updatedValue(String updated, String original) {
      return (updated == null) ? original : updated;
    }

    private Date updatedValue(Date updated, Date original) {
      return (updated == null) ? original : updated;
    }    
}