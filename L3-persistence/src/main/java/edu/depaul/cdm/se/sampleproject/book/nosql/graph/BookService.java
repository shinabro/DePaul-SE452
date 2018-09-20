package edu.depaul.cdm.se.sampleproject.book.nosql.graph;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.depaul.cdm.se.sampleproject.book.IBook;
import edu.depaul.cdm.se.sampleproject.book.IBookService;
import edu.depaul.cdm.se.sampleproject.book.jdbc.Book;
import org.neo4j.driver.v1.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService{
    private static final String SERVER = "bolt://34.227.93.73:32774";
    private static final String PASSWORD = "";
    private static final Driver DRIVER = GraphDatabase.driver(SERVER, AuthTokens.basic("neo4j", PASSWORD));

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
        bookBuilder.add("id", book.getId());
        bookBuilder.add("title", book.getTitle());
        bookBuilder.add("isbn", book.getIsbn());
        bookBuilder.add("author", book.getAuthor());

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        gson.toJson(book);
        String cypher = "CREATE (a:Book " + bookBuilder.build() +")";
        session.run(cypher);
        session.close();
    }
}
