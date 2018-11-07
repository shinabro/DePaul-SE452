package edu.depaul.cdm.se.sampleproject.book.data.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

//@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        System.out.println("Demo__1");
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        createExample();
        updateExample();
        getAuthorBooksExample();
        deleteExample();
    }

    private long author_id;
    private void createExample() {
        System.out.println(bookRepository.count());
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");

        Author author = new Author();
        author.setName("James");
        authorRepository.save(author);
        author_id = author.getId();

        book.setAuthor(author);

        bookRepository.save(book);

        System.out.println(bookRepository.count());
    }

    private void updateExample() {
        Book book = bookRepository.getOne(new Long(1));
        book.setTitle(book.getTitle() + " 2nd edition");
        bookRepository.save(book);
        book = new Book();
        System.out.println(book.getTitle());
        book = bookRepository.getOne(new Long(1));
        System.out.println(book.getTitle());
    }


    private void deleteExample() {
        System.out.println("Before delete: " + bookRepository.count());
        bookRepository.deleteById(new Long(1));
        System.out.println("After delete: " + bookRepository.count());
    }

    private void getAuthorBooksExample() {
        Author author = authorRepository.getOne(author_id);
        List<Book> books = author.getBooks();
        System.out.print(books.size());
    }
}
