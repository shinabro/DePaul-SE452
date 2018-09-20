package edu.depaul.cdm.se.sampleproject.book.spring.nosql.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("edu.depaul.cdm.se.sampleproject.book.spring.nosql.document")
public class Main implements CommandLineRunner {
    @Autowired
    BooksRepository repository;

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

    private static final String ISBN = "1-22-3333";
    private static final Long ID = new Long(1);

    private void createExample() {
        System.out.println(repository.count());
        Books book = new Books();
        book.setId(ID);
        book.setIsbn(ISBN);
        book.setTitle("Beginning Java Persistence");

        repository.save(book);

        System.out.println(repository.count());
    }

    private void updateExample() {
//        Books book = repository.findByisbn(ISBN).orElse(new Books());
        Books book = repository.findById(ID).orElse(new Books());
        book.setTitle(book.getTitle() + " 2nd edition");
        repository.save(book);
        book = new Books();
        System.out.println(book.getTitle());
        book = repository.findById(ID).orElse(new Books());
//        book = repository.findByisbn(ISBN).orElse(new Books());
        System.out.println(book.getTitle());
    }


    private void deleteExample() {
        System.out.println("Before delete: " + repository.count());
//        repository.findByisbn(ISBN);
        repository.deleteById(ID);
        System.out.println("After delete: " + repository.count());
    }
}
