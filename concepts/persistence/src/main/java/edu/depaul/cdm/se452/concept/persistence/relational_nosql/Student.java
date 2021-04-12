package edu.depaul.cdm.se452.concept.persistence.relational_nosql;

import java.sql.Date;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class Student {
	private long id;
	
	private String studentId;

	private String name;

	@Email(message = "not valid email address format")
	private String email;

	private Date admittedDate;
}