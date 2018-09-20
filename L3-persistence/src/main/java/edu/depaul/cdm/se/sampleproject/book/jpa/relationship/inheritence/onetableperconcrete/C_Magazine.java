package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.inheritence.onetableperconcrete;

import javax.persistence.Entity;

@Entity
public class C_Magazine extends C_Publication {
    private String issue;

    public String getIssue() {
        return this.issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
