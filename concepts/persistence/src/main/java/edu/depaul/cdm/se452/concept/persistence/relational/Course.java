package edu.depaul.cdm.se452.concept.persistence.relational;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

/**
 * Demo of setting up collection
 */
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    
    private String dept;    

    private int num;

    // To display list of course for students, need to start session or fetch eager
    @OneToMany   //(fetch = FetchType.EAGER)
    @JoinTable
    (
        name="COURSE_STUDENTS",
        joinColumns={ @JoinColumn(name="course_id", referencedColumnName="id")  }
    )
    @ToString.Exclude
    private List<Student> students; 
}