package edu.depaul.cdm.se452.concept.persistence.relational;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  @Bean
  public CommandLineRunner showStudents(StudentRepository repository) {
    return (args) -> {
      // fetch all Students
      log.info("Students found with findAll():");
      log.info("-------------------------------");
      repository.findAll().forEach((student) -> {
        log.info(student.toString());
      });
      log.info("-------------------------------");
    };
  }

  @Bean
  public CommandLineRunner showCourse(CourseRepository repository) {
    return (args) -> {
      // fetch all Course
      log.info("Course found with findAll():");
      log.info("-------------------------------");
      repository.findAll().forEach((course) -> {
        log.info(course.toString());
        // log.info("Students in course: " + course.getStudents().size());
      });
      log.info("-------------------------------");
    };
  }

  @Bean
  public CommandLineRunner addStudent(StudentRepository repository) {
    return (args) -> {
      // fetch all Course
      log.info("Before James: " + repository.count());
      Student student = new Student();
      student.setEmail("james@bond.uk");
      student.setName("James Bond");
      repository.save(student);
      log.info("After James: " + repository.count());
    };
  }

  @Bean
  public CommandLineRunner updateStudent(StudentRepository repository) {
    return (args) -> {
      // fetch all Course
      Optional<Student> stu = repository.findById((long) 1);
      Student updateStudent = stu.orElse(new Student());
      updateStudent.setName("updated " + updateStudent.getName());

      log.info(stu.toString());

      // Student student = new Student();
      repository.save(updateStudent);
      log.info("After James: " + repository.count());
    };
  }

}