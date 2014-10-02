package edu.depaul.se.jpa.basic.createdtables;

import edu.depaul.se.book.IBook;
import edu.depaul.se.book.jpa.Book;
import edu.depaul.se.book.jpa.BookService;
import edu.depaul.se.jpa.basic.AbstractJPATest;
import java.util.List;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest extends AbstractJPATest {

    public BookTest() {
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
        long bookId = book.getId();

        List<Book> books
                = getEm().createNamedQuery("findAllBooks").getResultList();
        assertTrue(books.size() >= 1);

        tx = getEm().getTransaction();
        tx.begin();
        book = getEm().find(Book.class, bookId);
        book.setTitle(book.getTitle() + " 2nd edition");
        tx.commit();

        Book updatedBook
                = getEm().createNamedQuery("findAllBooks", Book.class).setMaxResults(1).getSingleResult();
        assertEquals(book.getAuthor(), updatedBook.getAuthor());
        assertEquals(book.getTitle(), updatedBook.getTitle());

        int priorCount = getEm().createNamedQuery("findAllBooks").getResultList().size();
        tx = getEm().getTransaction();
        tx.begin();

        getEm().remove(updatedBook);
        tx.commit();

        int afterCount = getEm().createNamedQuery("findAllBooks").getResultList().size();

        assertEquals(afterCount + 1, priorCount);
    }

    //@Test
    public void testBookService() {
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");

        BookService service = new BookService();
        service.saveBook(book);
        assertNotNull("ID should have been generated and populated after persist",
                book.getId());

        List<IBook> books = service.getAllBooks();
        assertTrue(books.size() >= 1);
    }

}
