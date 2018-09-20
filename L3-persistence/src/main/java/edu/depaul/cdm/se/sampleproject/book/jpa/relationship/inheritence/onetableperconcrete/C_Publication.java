package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.inheritence.onetableperconcrete;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class C_Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
