package edu.depaul.se.jpa.basic.createdtables;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import org.eclipse.persistence.annotations.Cache;
//import org.eclipse.persistence.annotations.CacheType;



@Entity
//@Cache(type= CacheType.WEAK, expiry=60000)
@NamedQuery(name="findAllBooks", query="select b from Book b")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Version
    private Integer version;

    @NotNull
    private String title;
    
    @NotNull
    private String author;
    
    private String isbn;
    
    public Integer getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.depaul.se.jpa.basic.Book[ id=" + id + " ]";
    }
    
}
