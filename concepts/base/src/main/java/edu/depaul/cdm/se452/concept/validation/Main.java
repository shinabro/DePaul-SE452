package edu.depaul.cdm.se452.concept.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public void validateLength() {
    Course course = new Course();
    course.setDept("SE");
    course.setNum(452);

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Course>> violations = validator.validate(course);
    for (ConstraintViolation<Course> violation : violations) {
      System.err.println(violation.getMessage());
    }
    System.out.println("After SE");

    course.setDept("SECSC");
    course.setNum(1234);
    violations = validator.validate(course);

    for (ConstraintViolation<Course> violation : violations) {
      System.err.println(violation.getMessage());
    }
    System.out.println("After SECSC");

  }
  
  @Bean
  public void validateNumber() {
    Course course = new Course();
    course.setNum(452);

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Course>> violations = validator.validate(course);
    for (ConstraintViolation<Course> violation : violations) {
      System.err.println(violation.getMessage());
    }
    System.out.println("After 452");

    course.setNum(452);
    violations = validator.validate(course);

    for (ConstraintViolation<Course> violation : violations) {
      System.err.println(violation.getMessage());
    }
    System.out.println("After SECSC");

  }

  @Bean
  public void emailValidator() {
    Student student = new Student();
    student.setEmail("testoooooooo");
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Student>> violations = validator.validate(student);

    for (ConstraintViolation<Student> violation : violations) {
      System.err.println(violation.getMessage());
    }
    System.out.println("After invalid email");

    student.setEmail("kyu@cdm.depaul.edu");
    violations = validator.validate(student);

    for (ConstraintViolation<Student> violation : violations) {
      System.err.println(violation.getMessage());
    }
    System.out.println("After valid email");

  }

}