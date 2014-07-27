package edu.depaul.se.jpa.basic.existingtables;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Since tables are already defined as part of sample installation in NetBeans
 * <p>
 * Table Generation Strategy is set to None
 * <p>
 * This example leverages existing table that is installed with Derby out of the box database installation when using Eclpse or Netbeans
 * and so need to move the keep-table-as-is.xml as persistence.xml
 */
public class SelectorTest {
    
    public SelectorTest() {
    }
        // 1. Acquire Entity Manager 
    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void setUpClass() throws Exception {
        // 1. Acquire Entity Manager 
        emf = Persistence.createEntityManagerFactory("existingTablePU");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        em.close();
        emf.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testQueryViaDynamicQuery() {
        Query query = em.createQuery("select p from PurchaseOrder p");
        List<PurchaseOrder> result = query.getResultList();
        assertEquals(15, result.size());
    }
    
    @Test
    public void testQueryViaNamedQuery() {
        Query query = em.createNamedQuery(PurchaseOrder.PURCHASE_ORDER_QUERY_ALL);
        List<PurchaseOrder> result = query.getResultList();
        assertEquals(15, result.size());
    }
    
    @Test
    public void testQueryViaNativeQuery() {
        Query query = em.createNativeQuery("select * from purchase_order", PurchaseOrder.class);
        List<PurchaseOrder> result = query.getResultList();
        assertEquals(15, result.size());
    }
    
    @Test
    public void testQueryViaNativeNamedQuery() {
        Query query = em.createNamedQuery(PurchaseOrder.PURCHASE_ORDER_NATIVE_QUERY_ALL);
        List<PurchaseOrder> result = query.getResultList();
        assertEquals(15, result.size());
    }
    
    @Test
    public void testQueryUsingCustomerIdParameter() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        
        Query query = em.createNamedQuery(
                PurchaseOrder.PURCHASE_ORDER_QUERY_BY_CUSTOMER);
        query.setParameter(PurchaseOrder.CUSTOMER_ID_PARAMETER_NAME, customer);
        List<PurchaseOrder> result = query.getResultList();
        assertEquals(2, result.size());
    }
    
    @Test
    public void testQueryUsingCriteria() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PurchaseOrder> criteriaQuery = builder.createQuery(
                PurchaseOrder.class);
        Root<PurchaseOrder> po = criteriaQuery.from(PurchaseOrder.class);
        criteriaQuery.select(po).where(builder.equal(po.get("customerId"), customer));
        Query query = em.createQuery(criteriaQuery);
        List<PurchaseOrder> result = query.getResultList();
        
        assertEquals(2, result.size());
    }
}
