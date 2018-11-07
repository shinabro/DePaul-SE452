package edu.depaul.cdm.se.sampleproject.book.controller;

import edu.depaul.cdm.se.sampleproject.book.data.jpa.Author;
import edu.depaul.cdm.se.sampleproject.book.data.jpa.AuthorRepository;
import edu.depaul.cdm.se.sampleproject.book.data.jpa.BookRepository;
import edu.depaul.cdm.se.sampleproject.book.data.jpa.Book;
import edu.depaul.cdm.se.sampleproject.book.data.nosql.BookReviewRepository;
import edu.depaul.cdm.se.sampleproject.book.data.nosql.Review;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookReviewRepository reviewRepository;

    @GetMapping
    public String newBook(Model model) {
        logger.info("Num of book records in SQL: {}", bookRepository.findAll().size());
        List<Author> authors = authorRepository.findAll();
        Author author = new Author();

        model.addAttribute("book", new Book());
        model.addAttribute("authors", authors);
        model.addAttribute("author", author);

        return "book/new";
    }

    @PostMapping("/book_new")
    public String saveBook(Model model, @ModelAttribute Book book) {
        logger.info("Num of book records in SQL: {}", bookRepository.findAll().size());
        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

    @PostMapping
    public String saveComment(Model model, HttpServletRequest httpRequest, HttpSession httpSession) {
        logger.info("Num of book records in SQL: {}", bookRepository.findAll().size());
        String newComment = (String) httpRequest.getParameter("new_comment");
        String isbn = (String) httpSession.getAttribute("isbn");

        // Save the comment only when there is ISBN associated with it
        if (isbn != null) {
            Review review = new Review();
            review.setReview(newComment);
            review.setIsbn(isbn);
            reviewRepository.save(review);
        }

        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }


    @GetMapping(params = { "isbn" })
    public String formPost(Model model, @RequestParam("isbn") String isbn, HttpSession httpSession) {
        List<Book> books = bookRepository.findByIsbn(isbn);
        Book book = new Book();

        if (books.size() > 0)
            book = books.get(0);
        model.addAttribute("book", book);
        model.addAttribute("reviews", reviewRepository.findByIsbn(isbn));
        httpSession.setAttribute("isbn", isbn);
        return "book/edit";
    }    
}