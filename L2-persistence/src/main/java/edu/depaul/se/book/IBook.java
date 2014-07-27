package edu.depaul.se.book;

public interface IBook {

    boolean equals(Object object);

    String getAuthor();

    Long getId();

    String getIsbn();

    String getTitle();

    Integer getVersion();

    int hashCode();

    void setAuthor(String author);

    void setId(Long id);

    void setIsbn(String isbn);

    void setTitle(String title);

    String toString();
    
}
