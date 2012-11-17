package users.dao;

import org.junit.Before;

public class HibernateDAOTest extends GenericDAOTest {

    private HibernateDAO dao = new HibernateDAO();

    @Before
    public void setUp() throws Exception {
        setDAO(dao);
    }
}
