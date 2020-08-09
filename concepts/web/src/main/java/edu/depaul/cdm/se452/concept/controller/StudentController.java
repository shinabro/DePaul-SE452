package edu.depaul.cdm.se452.concept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.concept.model.IStudentService;
import edu.depaul.cdm.se452.concept.model.Student;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @PostMapping("/students")
    public Student add(@RequestBody Student student) {
      return studentService.add(student);
    }
  
    @GetMapping("/students/{id}")
    public Student find(@PathVariable String id) {
  
      return studentService.findById(id);
    }
  
    @PutMapping("/students/{id}")
    public Student update(@RequestBody Student updatStudent, @PathVariable String id) {  
      Student student = studentService.findById(id);
      student.setAdmittedDate(updatStudent.getAdmittedDate());
      student.setEmail(updatStudent.getEmail());
      student.setName(updatStudent.getName());
      return student;
    }
  
    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable String id) {
      studentService.deleteById(id);
    }
    
}