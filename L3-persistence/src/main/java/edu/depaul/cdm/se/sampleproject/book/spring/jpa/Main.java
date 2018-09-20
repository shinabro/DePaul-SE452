package edu.depaul.cdm.se.sampleproject.book.spring.jpa;

import edu.depaul.cdm.se.sampleproject.book.jpa.single.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("edu.depaul.cdm.se.sampleproject.book.spring.jpa")
public class Main implements CommandLineRunner {
    @Autowired
    BookRepository repository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        createExample();
        updateExample();
        deleteExample();
    }

    private void createExample() {
        System.out.println(repository.count());
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");

        repository.save(book);

        System.out.println(repository.count());
    }

    private void updateExample() {
        Book book = repository.getOne(new Long(1));
        book.setTitle(book.getTitle() + " 2nd edition");
        repository.save(book);
        book = new Book();
        System.out.println(book.getTitle());
        book = repository.getOne(new Long(1));
        System.out.println(book.getTitle());
    }


    private void deleteExample() {
        System.out.println("Before delete: " + repository.count());
        repository.deleteById(new Long(1));
        System.out.println("After delete: " + repository.count());
    }
}
