package edu.depaul.se.book.jdbc;

import edu.depaul.se.book.IBook;
import edu.depaul.se.book.IBookService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookService implements IBookService {

    private static Logger log = Logger.getLogger(BookService.class.getName());

    private static final String DB_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    
    private String connectionURL = "jdbc:hsqldb:hsql://localhost/mydb";
    private String userName = "SA";
    private String password = "SA";

    /**
     * Default connection of "jdbc:hsqldb:hsql://localhost/mydb";
     */
    public BookService() {
    }

    /**
     * Allow client to specify connection information
     * @param connectionString
     * @param user
     * @param password 
     */
    public BookService(String connectionString, String user, String password) {
        this.connectionURL = connectionString;
        this.userName = user;
        this.password = password;
    }

    @Override
    public void deleteBook(int bookId) {
        try {
            // Step 1:  Load database driver
            Class.forName(DB_DRIVER);

            // Step 2:  Request a connection from the DriverManager
            Connection con = getConnection();
            con.setAutoCommit(false);

            // Step 3:  Create a statement where the SQL statement will be provided
            PreparedStatement stmt = con.prepareStatement("delete from book where id = ?");

            stmt.setInt(1, bookId);

            // Step 4:  Get the resultset from the result of executing a query
            stmt.executeUpdate();

            con.commit();

            // Step 4:  Closing the connection
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<IBook> getAllBooks() {
        ArrayList<IBook> books = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName(DB_DRIVER);

            // Step 2:  Request a connection from the DriverManager
            con = getConnection();

            // Step 3:  Create a statement where the SQL statement will be provided
            Statement stmt = con.createStatement();

            // Step 4:  Get the resultset from the result of executing a query
            ResultSet rs = stmt.executeQuery("select id, author, isbn, title, version from book");

            // Step 5:  Processing the result
            while (rs.next()) {
                IBook book = map(rs);
                books.add(book);
            }

            // Step 6:  Closing the connection
            rs.close();
            stmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            // Will have to work out the proper exception handling b/c this is not 
            // proper
            log.log(Level.SEVERE, null, ex);
        } finally {
            if (con != null)
                try {
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return books;
    }

    @Override
    public void saveBook(IBook book) {
        try {
            Class.forName(DB_DRIVER);

            // Step 2:  Request a connection from the DriverManager
            Connection con = getConnection();
            con.setAutoCommit(false);

            // Step 3:  Create a statement where the SQL statement will be provided
            PreparedStatement stmt = con.prepareStatement("insert into book(id, isbn, title, author) values (?, ?, ?, ?)");

            stmt.setLong(1, book.getId());
            stmt.setString(2, book.getIsbn());
            stmt.setString(3, book.getTitle());
            stmt.setString(4, book.getAuthor());

            // Step 4:  Get the resultset from the result of executing a query
            int numOfAffectedRows = stmt.executeUpdate();

            con.commit();

            // Step 4:  Closing the connection
            stmt.close();
            con.close();

            if (numOfAffectedRows != 1) {
                log.log(Level.SEVERE, "Expected to have one row updated but there were none", book);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            log.log(Level.SEVERE, null, ex);
        }
    }

    private IBook map(ResultSet rs) {
        Book b = new Book();
        try {
            b.setId(rs.getLong("id"));
            b.setAuthor(rs.getString("author"));
            b.setIsbn(rs.getString("isbn"));
            b.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return b;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
