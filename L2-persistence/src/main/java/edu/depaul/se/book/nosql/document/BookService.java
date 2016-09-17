package edu.depaul.se.book.nosql.document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.depaul.se.book.IBook;
import edu.depaul.se.book.IBookService;
import edu.depaul.se.book.jdbc.Book;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 * Driver program to demo document database.  Be sure to start MongoDB before running the program.
 */
public class BookService implements IBookService {
    private static final MongoClient c = new MongoClient();
    /**
     * Note the open but no close since MongoClient close will close ALL connections
     * http://api.mongodb.com/java/2.10.0/com/mongodb/Mongo.html#close%28%29
     */
    private static final MongoCollection<Document> DB = c.getDatabase("test").getCollection("books");
    private static final String ISBN = "isbn";
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String BOOK = "book";
    
    @Override
    public void deleteBook(int bookId) {
        DB.deleteMany(new Document(ISBN, bookId));
    }

    /**
     * Change in the other delete option in that we are deleting based on ISBN which is a string rather than id
     * @param isbn
     * @return
     */
    public long deleteBook(String isbn) {
        return DB.deleteMany(new Document().append(ISBN, isbn)).getDeletedCount();
    }
    
    @Override
    public List<IBook> getAllBooks() {
        List<IBook> books = new ArrayList<>(); 
        FindIterable<Document> it = DB.find();
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
       DB.insertOne(new Document().
                append(ISBN, book.getIsbn()).
                append(TITLE, book.getTitle()).
                append(AUTHOR, book.getAuthor()));
   }
    
}
