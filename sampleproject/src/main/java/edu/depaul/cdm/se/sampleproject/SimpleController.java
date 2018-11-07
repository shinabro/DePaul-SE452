package edu.depaul.cdm.se.sampleproject;


import edu.depaul.cdm.se.sampleproject.book.data.jpa.AuthorRepository;
import edu.depaul.cdm.se.sampleproject.book.data.jpa.Book;
import edu.depaul.cdm.se.sampleproject.book.data.jpa.BookRepository;
import edu.depaul.cdm.se.sampleproject.book.data.nosql.BookReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(SampleprojectApplication.class);

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String getBookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

    @PostMapping("/book_new")
    public String saveBook(Model model, @ModelAttribute Book book) {
        logger.info("Num of book records in SQL: {}", bookRepository.findAll().size());
        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }
}