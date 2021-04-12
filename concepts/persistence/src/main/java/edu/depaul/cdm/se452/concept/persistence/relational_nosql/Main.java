package edu.depaul.cdm.se452.concept.persistence.relational_nosql;

import java.util.ArrayList;

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
  public CommandLineRunner saveCourseReview(CourseRepo repository) {
    return (args) -> {
      CourseReview review1 = new CourseReview();
      review1.setCourse("SE452");
      review1.setReview("Hard");

      CourseReview review2 = new CourseReview();
      review2.setCourse("SE252");
      review2.setReview("Fun");

      ArrayList<CourseReview> reviewList = new ArrayList<CourseReview>();
      reviewList.add(review1);
      reviewList.add(review2);

      Course course = new Course();
      course.setDept("CSC");
      course.setNum(452);
      course.setReviews(reviewList);

      repository.save(course);
    };
  }

}