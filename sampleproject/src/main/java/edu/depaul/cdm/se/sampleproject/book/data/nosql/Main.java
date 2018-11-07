package edu.depaul.cdm.se.sampleproject.book.data.nosql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.List;

//@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private BookReviewRepository repository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        createExample();
        nosqlList();
        findByISBN();
    }

    private static final String ISBN = "1-22-3333";
    private static final Long ID = new Long(1);

    private void createExample() {
        System.out.println(repository.count());
        Review review = new Review();
        review.setIsbn(ISBN);
        review.setReview("Great another book");
        repository.save(review);

        System.out.println(repository.count());
    }


    private void nosqlList() {
        List<Review> reviews = repository.findAll();
        System.out.println(reviews);
    }

    private void findByISBN() {
        List<Review> reviews = repository.findByIsbn(ISBN);
        System.out.println(reviews.size());
    }

}
