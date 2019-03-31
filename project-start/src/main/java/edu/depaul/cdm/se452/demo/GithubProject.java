package edu.depaul.cdm.se452.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * GithubProject
 */
@Entity
public class GithubProject implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String orgName;

    @Column(unique = true)
    private String repoName;

    /**
     * @return the repoName
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * @param repoName the repoName to set
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public GithubProject(String orgName, String repoName) {
        this.orgName = orgName;
        this.repoName = repoName;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}