package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.onetomany;

import edu.depaul.cdm.se.sampleproject.relationship.onemanyembed.PurchaseOrder;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class R_Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "id",
            fetch = FetchType.EAGER)
    private Collection<R_Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
