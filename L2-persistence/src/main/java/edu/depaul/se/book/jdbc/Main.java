package edu.depaul.se.book.jdbc;

import edu.depaul.se.book.IBook;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.createExample();
        main.findEntity();
    }

    private void createExample() {
        BookService services = new BookService();
        Book book = new Book();
        book.setId(new Random().nextLong());
        book.setTitle("Beginning Java Persistence");

        book.setAuthor("James");
        book.setIsbn("12-123-1234");
        services.saveBook(book);
    }

    private void findEntity() {
        BookService services = new BookService();
        List<IBook> books = services.getAllBooks();
        System.out.println(books);
    }
}
