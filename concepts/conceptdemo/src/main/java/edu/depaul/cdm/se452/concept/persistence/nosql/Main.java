package edu.depaul.cdm.se452.concept.persistence.nosql;

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
  public CommandLineRunner showStudents(CourseReviewRepository repository) {
    return (args) -> {
      CourseReview review = new CourseReview();
      review.setCourse("SE452");
      review.setReview("Fun");
      repository.save(review);
    };
  }

}