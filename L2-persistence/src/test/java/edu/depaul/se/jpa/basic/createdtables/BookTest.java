package edu.depaul.se.jpa.basic.createdtables;

import edu.depaul.se.book.IBook;
import edu.depaul.se.book.jpa.Book;
import edu.depaul.se.book.jpa.BookService;
import edu.depaul.se.jpa.basic.AbstractJPATest;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class BookTest extends AbstractJPATest {

    private static Validator validator;

    public BookTest() {
    }

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testBookCRUD() {
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");

        EntityTransaction tx = getEm().getTransaction();

        tx.begin();
        getEm().persist(book);
        tx.commit();
        assertNotNull("ID should have been generated and populated after persist",
                book.getId());

        List<Book> books
                = getEm().createNamedQuery("findAllBooks").getResultList();
        assertEquals(1, books.size());

        tx = getEm().getTransaction();
        tx.begin();
        book = getEm().find(Book.class, new Long(1));
        book.setTitle(book.getTitle() + " 2nd edition");
        tx.commit();

        Book updatedBook
                = getEm().createNamedQuery("findAllBooks", Book.class).getSingleResult();
        assertEquals(book, updatedBook);

        int priorCount = getEm().createNamedQuery("findAllBooks").getResultList().size();
        tx = getEm().getTransaction();
        tx.begin();
        book = getEm().find(Book.class, new Long(1));
        getEm().remove(book);
        tx.commit();

        int afterCount = getEm().createNamedQuery("findAllBooks").getResultList().size();

        assertEquals(afterCount + 1, priorCount);
    }

    @Test
    public void testBookService() {
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");

        BookService service = new BookService();
        service.saveBook(book);
        assertNotNull("ID should have been generated and populated after persist",
                book.getId());

        List<IBook> books = service.getAllBooks();
        assertEquals(1, books.size());
    }

    @Test
    public void testValidator() {
        Book book = new Book();
        // Required fields of Author and Title is not there and so validation would fail
        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        assertEquals(2, constraintViolations.size());

        book.setTitle("How to program in Java");
        book.setAuthor("Deither & Deither");
        constraintViolations = validator.validate(book);
        // After the title and author has been set, there is no errors and so the validation would be cleared
        assertEquals(0, constraintViolations.size());
    }
}
