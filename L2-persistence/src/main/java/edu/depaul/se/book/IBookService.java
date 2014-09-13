package edu.depaul.se.book;

import java.util.List;

public interface IBookService {

    void deleteBook(int bookId);

    List<IBook> getAllBooks();

    void saveBook(IBook book);
    
}
