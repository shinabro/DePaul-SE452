package edu.depaul.cdm.se.sampleproject.book.nosql.document;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import edu.depaul.cdm.se.sampleproject.book.IBook;
import edu.depaul.cdm.se.sampleproject.book.IBookService;
import edu.depaul.cdm.se.sampleproject.book.jdbc.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 * Books service for NoSQL MongoDB
 * @see <a href="http://api.mongodb.com/java/current/">http://api.mongodb.com</a>
 */
public class BookService implements IBookService {
    private MongoClient mongoClient;
    /**
     * Note the open but no close since MongoClient close will close ALL connections
     * http://api.mongodb.com/java/2.10.0/com/mongodb/Mongo.html#close%28%29
     */

    private MongoCollection<Document> db;
    private static final String ISBN = "isbn";
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String BOOK = "book";

    private static final String USER_NAME = "";
    private static final String PASSWORD = "";
    private static final String MONGO_URL = "mongodb://"+USER_NAME+":"+PASSWORD + "@ds139869.mlab.com:39869/depaul-sandbox";
    private static final String COLLECTION_NAME = "books";

    public BookService() {
        MongoClientURI uri  = new MongoClientURI(MONGO_URL);
        mongoClient = new MongoClient(uri);

        db = mongoClient.getDatabase(uri.getDatabase()).getCollection(COLLECTION_NAME);
    }

    @Override
    public void deleteBook(int bookId) {
        db.deleteMany(new Document(ISBN, bookId));
    }

    /**
     * Change in the other delete option in that we are deleting based on ISBN which is a string rather than id
     * @param isbn
     * @return
     */
    public long deleteBook(String isbn) {
        return db.deleteMany(new Document().append(ISBN, isbn)).getDeletedCount();
    }
    
    @Override
    public List<IBook> getAllBooks() {
        List<IBook> books = new ArrayList<>(); 
        FindIterable<Document> it = db.find();
        it.forEach(new Block<Document>() {
            @Override
            public void apply(Document d) {
                Book b = new Book();
                b.setIsbn(d.get(ISBN, String.class));
                b.setAuthor(d.get(AUTHOR, String.class));
                b.setTitle(d.get(TITLE, String.class));
                books.add(b);
            }

        });
        
        return books;
    }

    @Override
    public void saveBook(IBook book) {
       db.insertOne(new Document().
                append(ISBN, book.getIsbn()).
                append(TITLE, book.getTitle()).
                append(AUTHOR, book.getAuthor()));
   }
    
}
