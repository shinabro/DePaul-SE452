package edu.depaul.cdm.se452.concept.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.cdm.se452.concept.model.IStudentService;
import edu.depaul.cdm.se452.concept.model.Student;

@Controller
@RequestMapping("student")
public class StudentController {

  @Autowired
  private IStudentService studentService;

  @GetMapping
  public ModelAndView showStudents() {
    ModelAndView mv = new ModelAndView("list-students");
    mv.addObject("students", studentService.findAll());
    return mv;
  }

  @GetMapping("/add")
  public String showSignUpForm(Student student) {
      return "add-student";
  }

  @PostMapping
  public String add(@Valid Student student, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "add-student";
    }

    studentService.update(student);
    model.addAttribute("students", studentService.findAll());
    return "redirect:/student";
  }

  @GetMapping("/edit/{id}")
  public String showEdit(@PathVariable("id") String studentId, Model model) {
    Student student = studentService.findById(studentId);
    model.addAttribute("student", student);
    return "edit-student";  
  }

  @PostMapping("/edit")
  public String update(@Valid Student student, BindingResult result) {
    if (result.hasErrors()) {
      return "edit-student";
    }

    studentService.update(student);
    return "redirect:/student";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") String studentId, Model model) {
      studentService.deleteById(studentId);
      return "redirect:/student";
  }  

}