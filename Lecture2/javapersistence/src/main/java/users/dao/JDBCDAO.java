package users.dao;

import users.IUser;
import users.IUserDAO;
import users.UserPersistenceException;
import users.dao.dataobject.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Example data access using JDBC techniques
 */
public class JDBCDAO implements IUserDAO {

    //private String connectionUrl = "jdbc:hsqldb:hsql://localhost/mydb";
	private String connectionUrl = "jdbc:hsqldb:mem:.";
    private String userName = "";
    private String password = "";

    static {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    public JDBCDAO(String connectionUrl, String name, String password) {
        this.connectionUrl = connectionUrl;
        this.userName = name;
        this.password = password;
    }

    public JDBCDAO() {
    }

    /**
     * Example using statement
     */
    public List<IUser> getUsers() throws UserPersistenceException {
        ArrayList<IUser> users = new ArrayList<IUser>();

        try {
            // Step 2:  Request a connection from the DriverManager
            Connection con = getConnection();

            // Step 3:  Create a statement where the SQL statement will be provided
            Statement stmt = con.createStatement();

            // Step 4:  Get the resultset from the result of executing a query
            ResultSet rs = stmt.executeQuery("select * from users");

            // Step 5:  Processing the result
            while (rs.next()) {
                IUser user = map(rs);
                users.add(user);
            }

            // Step 6:  Closing the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException sql) {
            throw new UserPersistenceException(sql);
        }

        return users;
    }

    /**
     * Example using prepared statement
     */
    public List<IUser> getUsers(String userName) throws UserPersistenceException {
        ArrayList<IUser> users = new ArrayList<IUser>();

        try {
            // Step 2:  Request a connection from the DriverManager
            Connection con = getConnection();

            // Step 3:  Create a statement where the SQL statement will be provided
            PreparedStatement stmt = con.prepareStatement("select * from users where name = ?");
            stmt.setString(1, userName);

            // Step 4:  Get the resultset from the result of executing a query
            ResultSet rs = stmt.executeQuery();

            // Step 5:  Processing the result
            while (rs.next()) {
                IUser user = map(rs);
                users.add(user);
            }

            // Step 5:  Closing the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException sql) {
            throw new UserPersistenceException(sql);
        }

        return users;
    }

    public int saveUser(IUser user) throws UserPersistenceException {
        int iRetVal = user.getId();

        if (iRetVal > 0) {
            updateUser(user);
        } else {
            iRetVal = createUser(user);
        }

        return iRetVal;
    }

    private void updateUser(IUser user) throws UserPersistenceException {
        try {
            // Step 2:  Request a connection from the DriverManager
            Connection con = getConnection();
            con.setAutoCommit(false);

            // Step 3:  Create a statement where the SQL statement will be provided
            PreparedStatement stmt = con.prepareStatement("update users set name = ? where id = ?");

            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getId());

            // Step 4:  Get the resultset from the result of executing a query
            int numOfAffectedRows = stmt.executeUpdate();

            con.commit();

            // Step 4:  Closing the connection
            stmt.close();
            con.close();

            if (numOfAffectedRows != 1) {
                throw new UserPersistenceException("Updated " + numOfAffectedRows + " rows but were expecting to update 1");
            }
        } catch (SQLException sql) {
            throw new UserPersistenceException(sql);
        }

    }

    private int createUser(IUser user) throws UserPersistenceException {
        int newUserId = -1;

        try {
            // Step 2:  Request a connection from the DriverManager
            Connection con = getConnection();
            con.setAutoCommit(false);

            // Step 3:  Create a statement where the SQL statement will be provided
            PreparedStatement stmt = con.prepareStatement("insert into users(name) values(?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, user.getName());

            // Step 4:  Get the resultset from the result of executing a query
            int numOfAffectedRows = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (numOfAffectedRows == 0) {
                throw new UserPersistenceException("Rows did not get updated");
            }

            rs.next();
            newUserId = rs.getInt(1);

            con.commit();

            // Step 4:  Closing the connection
            stmt.close();
            con.close();
        } catch (SQLException sql) {
            UserPersistenceException upe = new UserPersistenceException(sql);
            throw upe;
        }

        return newUserId;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, userName, password);
    }

    private IUser map(ResultSet rs) throws SQLException {
        return map(rs.getInt(1), rs.getString(2));
    }

    private IUser map(int id, String name) {
        IUser user = new User();
        user.setId(id);
        user.setName(name);

        return user;
    }

    public void deleteUser(IUser user) throws UserPersistenceException {
        try {
            // Step 2:  Request a connection from the DriverManager
            Connection con = getConnection();
            con.setAutoCommit(false);

            // Step 3:  Create a statement where the SQL statement will be provided
            PreparedStatement stmt = con.prepareStatement("delete from users where id = ?");

            stmt.setInt(1, user.getId());

            // Step 4:  Get the resultset from the result of executing a query
            stmt.executeUpdate();

            con.commit();

            // Step 4:  Closing the connection
            stmt.close();
            con.close();
        } catch (SQLException sql) {
            throw new UserPersistenceException(sql);
        }
    }
}
