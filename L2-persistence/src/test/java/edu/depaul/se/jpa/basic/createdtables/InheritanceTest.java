package edu.depaul.se.jpa.basic.createdtables;

import edu.depaul.se.jpa.basic.AbstractJPATest;
import edu.depaul.se.jpa.basic.createdtables.oneclassperhierarchy.HourlyEmployee;
import edu.depaul.se.jpa.basic.createdtables.oneclassperhierarchy.SalaryEmployee;
import edu.depaul.se.jpa.basic.createdtables.onetableperclass.T_HourlyEmployee;
import edu.depaul.se.jpa.basic.createdtables.onetableperclass.T_SalaryEmployee;
import edu.depaul.se.jpa.basic.createdtables.onetableperconcrete.C_HourlyEmployee;
import edu.depaul.se.jpa.basic.createdtables.onetableperconcrete.C_SalaryEmployee;
import javax.persistence.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Since tables need to be created make sure that on persistence.xml <p> Table
 * Generation Strategy is set to Drop and Create <property
 * name="eclipselink.ddl-generation" value="drop-and-create-tables"/> <p>
 * ---------------------------------------------------------------------------------
 * To support this activity, please copy the content of drop-create-table.xml
 * into persistence.xml before running this test
 * ---------------------------------------------------------------------------------
 */
public class InheritanceTest extends AbstractJPATest {

    public InheritanceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testOneTablePerClassHierarchy() {
        HourlyEmployee hourly = new HourlyEmployee();
        hourly.setName("name");
        hourly.setHourlyRate(9);

        SalaryEmployee salary = new SalaryEmployee();
        salary.setName("name");
        salary.setSalary(10000);

        assertNull(hourly.getId());
        assertNull(salary.getId());

        EntityTransaction tx = getEm().getTransaction();
        try {
            tx.begin();
            getEm().persist(hourly);
            getEm().persist(salary);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

        assertNotNull(hourly.getId());
        assertNotNull(salary.getId());
    }

    @Test
    public void testOneTablePerConcreteClass() {
        T_HourlyEmployee hourly = new T_HourlyEmployee();
        hourly.setName("name");
        hourly.setHourlyRate(9);

        T_SalaryEmployee salary = new T_SalaryEmployee();
        salary.setName("name");
        salary.setSalary(10000);

        assertNull(hourly.getId());
        assertNull(salary.getId());

        EntityTransaction tx = getEm().getTransaction();
        try {
            tx.begin();
            getEm().persist(hourly);
            getEm().persist(salary);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        assertNotNull(hourly.getId());
        assertNotNull(salary.getId());
    }

    @Test
    public void testOneTablePerClass() {
        C_HourlyEmployee hourly = new C_HourlyEmployee();
        hourly.setName("name");
        hourly.setHourlyRate(9);

        C_SalaryEmployee salary = new C_SalaryEmployee();
        salary.setName("name");
        salary.setSalary(10000);

        assertNull(hourly.getId());
        assertNull(salary.getId());

        EntityTransaction tx = getEm().getTransaction();
        try {
            tx.begin();
            getEm().persist(hourly);
            getEm().persist(salary);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

        assertNotNull(hourly.getId());
        assertNotNull(salary.getId());

    }
}
