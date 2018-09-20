package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.onetomany;

import edu.depaul.cdm.se.sampleproject.book.IBook;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "findAllBooks", query = "select b from R_Book b")
public class R_Book implements Serializable, IBook {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @NotNull
    private String title;

    @JoinColumn(name = "id", referencedColumnName = "author_id")
    @ManyToOne(optional = false)
    private R_Author author;

    private String isbn;

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public String getAuthor() {
        return author.getName();
    }

    @Override
    public void setAuthor(String author) {
        this.author.setName(author);
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
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
        if (!(object instanceof R_Book)) {
            return false;
        }
        R_Book other = (R_Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder retval = new StringBuilder();
        retval.append("R_Book{");
        retval.append("id=");
        retval.append(id);
        retval.append(", title=");
        retval.append(title);

        return retval.toString();

    }
}
