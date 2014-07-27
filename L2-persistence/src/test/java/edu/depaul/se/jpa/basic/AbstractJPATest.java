package edu.depaul.se.jpa.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class AbstractJPATest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void setUpClass() throws Exception {
        // 1. Acquire Entity Manager 
        setEmf(Persistence.createEntityManagerFactory("jpaPU"));
        setEm(getEmf().createEntityManager());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        getEm().close();
        getEmf().close();
    }

    /**
     * @return the emf
     */
    public static EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param aEmf the emf to set
     */
    public static void setEmf(EntityManagerFactory aEmf) {
        emf = aEmf;
    }

    /**
     * @return the em
     */
    public static EntityManager getEm() {
        return em;
    }

    /**
     * @param aEm the em to set
     */
    public static void setEm(EntityManager aEm) {
        em = aEm;
    }
}
