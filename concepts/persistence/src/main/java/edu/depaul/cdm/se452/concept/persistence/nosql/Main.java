package edu.depaul.cdm.se452.concept.persistence.nosql;

import java.util.List;

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
  public CommandLineRunner saveCourseReview(CourseReviewRepository repository) {
    return (args) -> {
      CourseReview review1 = new CourseReview();
      review1.setCourse("SE452");
      review1.setReview("Hard");
      repository.save(review1);

      CourseReview review2 = new CourseReview();
      review2.setCourse("SE252");
      review2.setReview("Fun");
      repository.save(review2);      
    };
  }

  @Bean
  public CommandLineRunner showCourseReview(CourseReviewRepository repository) {
    return (args) -> {
      List<CourseReview> reviews = repository.findAll();
      for (CourseReview review : reviews) {
        log.info(review.toString());
      }
    };
  }

}