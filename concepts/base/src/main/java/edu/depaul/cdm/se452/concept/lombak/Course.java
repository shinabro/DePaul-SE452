package edu.depaul.cdm.se452.concept.lombak;

import java.util.List;

import lombok.Data;

/**
 * Demo of setting up collection
 */
@Data
public class Course {
    private String dept;    

    private int num;

    private List<Student> enrolledStudents;    
}