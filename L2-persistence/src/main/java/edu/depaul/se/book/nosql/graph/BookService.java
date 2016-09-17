package edu.depaul.se.book.nosql.graph;

import com.google.gson.Gson;
import edu.depaul.se.book.IBook;
import edu.depaul.se.book.IBookService;
import edu.depaul.se.book.jdbc.Book;
import org.neo4j.driver.v1.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService{
    private static final Driver DRIVER = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "password"));

    public BookService() {

    }
    @Override
    public void deleteBook(int bookId) {

    }

    @Override
    public List<IBook> getAllBooks() {
        Session session = DRIVER.session();
        List<IBook> books = new ArrayList<>();
        StatementResult result = session.run("MATCH (n:Book) RETURN n");
        while (result.hasNext()) {
            Record record = result.next();
            Gson gSon = new Gson();
            String obj = gSon.toJson(record.asMap());
            Book book = gSon.fromJson(obj, Book.class);
            books.add(book);

            System.out.println(record.get("title").asString() + " " + record.get("author").asString());
        }

        session.close();

        return books;
    }

    @Override
    public void saveBook(IBook book) {
        Session session = DRIVER.session();

        JsonObjectBuilder bookBuilder = Json.createObjectBuilder();
        bookBuilder.add("title", book.getTitle());
        bookBuilder.add("isbn", book.getIsbn());
        bookBuilder.add("author", book.getAuthor());

        session.run("CREATE (a:Book " + bookBuilder.build().toString()+")");
        session.close();
    }
}
