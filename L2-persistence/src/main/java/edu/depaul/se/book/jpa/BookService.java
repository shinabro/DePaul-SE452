package edu.depaul.se.book.jpa;

import edu.depaul.se.book.IBookService;
import edu.depaul.se.book.IBook;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Service layer around book persistence
 */
public class BookService implements IBookService {

    private EntityManager em;

    public BookService() {
        em = Persistence.createEntityManagerFactory("jpa-demoPU").createEntityManager();
    }

    @Override
    public void saveBook(IBook book) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        IBook bookToUpdate;
        if ((book.getId() != null) && (book.getId() > 0)) {
            bookToUpdate = em.find(Book.class, book.getId());
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setIsbn(book.getIsbn());
            bookToUpdate.setAuthor(book.getAuthor());
        } else {
            bookToUpdate = book;
        }

        em.persist(bookToUpdate);
        tx.commit();
    }

    @Override
    public List<IBook> getAllBooks() {
        return em.createNamedQuery("findAllBooks").getResultList();
    }

    @Override
    public void deleteBook(int bookId) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Book book = em.find(Book.class, bookId);
        em.remove(book);
        tx.commit();
    }
}
