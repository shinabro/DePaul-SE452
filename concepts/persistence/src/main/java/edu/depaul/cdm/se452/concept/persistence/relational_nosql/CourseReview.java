package edu.depaul.cdm.se452.concept.persistence.relational_nosql;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class CourseReview implements Serializable {  
    private String course;
    private String review;
    private String reviewer;
    private Date reviewDate;
}