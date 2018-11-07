package edu.depaul.cdm.se.sampleproject.book;

import edu.depaul.cdm.se.sampleproject.book.data.jpa.BookRepository;
import edu.depaul.cdm.se.sampleproject.book.data.jpa.Book;
import edu.depaul.cdm.se.sampleproject.book.data.nosql.BookReviewRepository;
import edu.depaul.cdm.se.sampleproject.book.data.nosql.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.List;


//@SpringBootApplication
public class Main implements CommandLineRunner  {
    @Autowired
    private BookRepository repository;

    @Autowired
    private BookReviewRepository bookReviewRepository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        System.out.println("Demo__3");
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-- Begin SQL ---");
        sqlCreate();
        sqlUpdate();
        sqlDelete();
        System.out.println("-- End SQL ---");

        System.out.println("-- Begin NoSQL ---");
        nosqlCreate();
        nosqlList();
        System.out.println("-- End NoSQL ---");
    }


    private static final String ISBN = "1-22-3333";
    private static final Long ID = new Long(1);

    private void nosqlCreate() {
        Review review = new Review();
        review.setReview("Great book");
        review.setIsbn(ISBN);

        bookReviewRepository.save(review);
    }


    private void nosqlList() {
        List<Review> reviews = bookReviewRepository.findAll();
        System.out.println(reviews);
    }

    private void sqlCreate() {
        System.out.println(repository.count());
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");

        repository.save(book);

        System.out.println(repository.count());
    }

    private void sqlUpdate() {
        Book book = repository.getOne(new Long(1));
        book.setTitle(book.getTitle() + " 2nd edition");
        repository.save(book);
        book = new Book();
        System.out.println(book.getTitle());
        book = repository.getOne(new Long(1));
        System.out.println(book.getTitle());
    }


    private void sqlDelete() {
        System.out.println("Before delete: " + repository.count());
        repository.deleteById(new Long(1));
        System.out.println("After delete: " + repository.count());
    }

}