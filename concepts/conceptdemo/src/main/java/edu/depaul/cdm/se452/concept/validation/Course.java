package edu.depaul.cdm.se452.concept.validation;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class Course {
    // Sample course is SE452 where SE is the Deparment code
    @Size(min = 2, max = 2, message = "department code must be less than 3 characters")
    private String dept;    

    @Min(value = 0, message = "number can not be negative")
    @Max(value = 999, message = "number must be less than 999")
    private int num;

    private List<Student> enrolledStudents;    
}