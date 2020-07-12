package edu.depaul.cdm.se452.concept.lombak;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
    }
    
    @Bean
    public void sampleGetterSetter() {
        Student student = new Student();
        System.out.print("Before: ");
        System.out.println(student);
        student.setName("dave");
        System.out.print("After: ");
        System.out.println(student);
    }

    @Bean
    public void sampleList() {
        Course course = new Course();
        ArrayList<Student> enrolledStudents = new ArrayList<Student>();
        Student a = new Student();
        a.setName("ken");
        enrolledStudents.add(a);
        course.setEnrolledStudents(enrolledStudents);
        System.out.println(course);
    }

}