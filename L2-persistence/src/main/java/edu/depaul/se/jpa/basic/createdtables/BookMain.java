package edu.depaul.se.jpa.basic.createdtables;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * JPA using main
 * Be sure to start the database before starting this
 */
public class BookMain {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static void main(String[] args) {
        BookMain main = new BookMain();
        emf = Persistence.createEntityManagerFactory("jpa-demoPU");
        em = emf.createEntityManager();
        main.createExample();
        main.findEntity();
        main.updateExample();
        main.deleteExample();
        em.close();
        emf.close();
    }

    private void createExample() {
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.print("Before save: ");
        System.out.println(book.getId());
        em.persist(book);
        System.out.print("After save: ");
        System.out.println(book.getId());
        tx.commit();
        
        List<Book> books = 
                em.createNamedQuery("findAllBooks").getResultList();
        
        System.out.println("Number of rows: " + books.size());
    }
    
    private void updateExample() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Book book = em.find(Book.class, new Long(1));
        System.out.println(book);
        book.setTitle(book.getTitle() + " 2nd edition");
        tx.commit();
        
        List<Book> books = 
                em.createNamedQuery("findAllBooks").getResultList();
        System.out.println(books.get(0));
    }
    
    private void deleteExample() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Book book = em.find(Book.class, new Long(1));
        System.out.println(book);
        em.remove(book);
        tx.commit();
        
        List<Book> books = 
                em.createNamedQuery("findAllBooks").getResultList();
        System.out.print("After delete number of rows remaining is: ");
        System.out.println(books.size());
    }
    
    private void findEntity() {
        
        // 2a.  Find the entity via primary key, auto configured
        Book book = em.find(Book.class, new Long(1));
        
        // 2b.  Find via query, manually configured, see Book class definition
        List<Book> books = 
                em.createNamedQuery("findAllBooks").getResultList();
        
    }
    
    private void deleteEntity() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Book book = em.find(Book.class, new Long(1));
        System.out.println(book);
        em.remove(book);
        tx.commit();
        
        List<Book> books = 
                em.createNamedQuery("findAllBooks").getResultList();
        System.out.print("After delete number of rows remaining is: ");
        System.out.println(books.size());
    }
    
}
