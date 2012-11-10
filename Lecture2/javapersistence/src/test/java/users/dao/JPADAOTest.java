package users.dao;

import org.junit.Before;

public class JPADAOTest extends GenericDAOTest {
    @Before
    public void setUp() throws Exception {
        setDAO(new JPADAO());
    }
}
