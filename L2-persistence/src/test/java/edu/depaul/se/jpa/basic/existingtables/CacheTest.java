package edu.depaul.se.jpa.basic.existingtables;

import edu.depaul.se.jpa.basic.AbstractJPATest;
import edu.depaul.se.jpa.basic.createdtables.Book;
import javax.persistence.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test to show Cache at work
 */
public class CacheTest extends AbstractJPATest {

    @Test
    public void testAfterCacheIsEnabled() {
        Book book = new Book();
        book.setAuthor("Bill Burke");
        book.setTitle("Enterprise JavaBeans 3.1");
        Cache cache = getEmf().getCache();

        EntityTransaction tx = getEm().getTransaction();
        tx.begin();
        getEm().persist(book);
        tx.commit();
        int version1 = book.getVersion();

        tx.begin();
        book.setAuthor("Andrew lee Rubinger");
        getEm().merge(book);
        tx.commit();
        int version2 = book.getVersion();

        assertFalse(version1 == version2);
        // Make sure that the value is in cache
        // This will fail if Cacheable is set to false in Book entity
        assertTrue(cache.contains(Book.class, book.getId()));
        cache.evict(Book.class);

        // Now that cache has been removed, there should not be any books in cache
        assertFalse(cache.contains(Book.class, book.getId()));

    }
}
