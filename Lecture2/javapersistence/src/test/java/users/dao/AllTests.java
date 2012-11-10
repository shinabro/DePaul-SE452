package users.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HibernateDAOTest.class, JDBCDAOTest.class, JPADAOTest.class })
public class AllTests {

}
