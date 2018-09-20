package edu.depaul.cdm.se.sampleproject.book.jdbc;

import edu.depaul.cdm.se.sampleproject.book.IBook;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.example();
    }

    private void example() {
        BookService services = new BookService();
        Book book = new Book();
        book.setId(new Random().nextLong());
        book.setTitle("Beginning Java Persistence");

        book.setAuthor("James");
        book.setIsbn("12-123-1234");
        services.saveBook(book);

        List<IBook> books = services.getAllBooks();
        System.out.println(books);
    }

}
