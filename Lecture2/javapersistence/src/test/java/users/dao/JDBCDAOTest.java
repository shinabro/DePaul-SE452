package users.dao;

import org.junit.Before;

public class JDBCDAOTest extends GenericDAOTest {

    @Before
    public void setUp() throws Exception {
        setDAO(new JDBCDAO());
    }
}
