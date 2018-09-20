package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.inheritence.oneclassperhierarchy;

import javax.persistence.Entity;

@Entity
public class H_Magazine extends H_Publication {
    private String issue;

    public String getIssue() {
        return this.issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
