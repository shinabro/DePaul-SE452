package edu.depaul.se.jpa.basic.createdtables;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Service layer around book persistence
 */
public class BookService {

    private EntityManager em;

    public BookService() {
        em = Persistence.createEntityManagerFactory("jpaPU").createEntityManager();
    }

    public void saveBook(Book book) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Book bookToUpdate;
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

    public List<Book> getAllBooks() {
        return em.createNamedQuery("findAllBooks").getResultList();
    }

    public void deleteBook(int bookId) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Book book = em.find(Book.class, bookId);
        em.remove(book);
        tx.commit();
    }
}
