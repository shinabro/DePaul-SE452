package edu.depaul.se.book.nosql.document;

import edu.depaul.se.book.IBook;
import edu.depaul.se.book.jdbc.Book;
import java.util.List;


/**
 * Demo
 */
public class Main {

    public static void main(String[] args)  {
        Main main = new Main();
        main.createExample();
        main.showEntities();
        main.deleteExample();
        main.showEntities();
    }
    private void createExample() {
        BookService services = new BookService();
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");

        book.setAuthor("James");
        book.setIsbn("12-123-1234");
        services.saveBook(book);
    }
    
    private void deleteExample() {
        BookService services = new BookService();
        if (services.deleteBook("12-123-1234") > 0)
            System.out.println("Yeah it worked");
    }

    private void showEntities() {
        BookService services = new BookService();
        List<IBook> books = services.getAllBooks();
        System.out.println(books);
    }
    
}