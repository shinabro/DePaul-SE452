package edu.depaul.cdm.se.sampleproject.book.nosql.graph;

import edu.depaul.cdm.se.sampleproject.book.IBook;
import edu.depaul.cdm.se.sampleproject.book.jdbc.Book;
import org.neo4j.driver.v1.*;

import java.util.List;

/**
 * Driver program to demo Graph database.  Besure to start Neo4J before starting
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.createExample();
        m.showEntities();
    }
    private void createExample() {
        BookService services = new BookService();
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");

        book.setAuthor("James");
        book.setIsbn("12-123-1234");
        services.saveBook(book);
        System.out.println(book.getId());
    }

    private void deleteExample() {
        BookService services = new BookService();
//        if (services.deleteBook("12-123-1234") > 0)
            System.out.println("Yeah it worked");
    }

    private void showEntities() {
        BookService services = new BookService();
        List<IBook> books = services.getAllBooks();
        System.out.println(books);
    }

}
