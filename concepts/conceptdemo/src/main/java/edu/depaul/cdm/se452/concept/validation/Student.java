package edu.depaul.cdm.se452.concept.validation;

import java.sql.Date;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class Student {
	private String studentId;

	private String name;

	@Email(message = "not valid email address format")
	private String email;

	private Date admittedDate;

}