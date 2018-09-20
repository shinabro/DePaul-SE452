package edu.depaul.cdm.se.sampleproject.book.jpa.relationship.inheritence.onetableperclass;

import javax.persistence.Entity;

@Entity
public class T_Magazine extends T_Publication {
    private String issue;

    public String getIssue() {
        return this.issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
