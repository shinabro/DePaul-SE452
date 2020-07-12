package edu.depaul.cdm.se452.concept.lombak;

import java.sql.Date;

import lombok.Data;

@Data
public class Student {
	private String studentId;

	private String name;

	private String email;

	private Date admittedDate;

}