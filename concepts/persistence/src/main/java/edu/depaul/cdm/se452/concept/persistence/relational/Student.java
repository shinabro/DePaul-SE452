package edu.depaul.cdm.se452.concept.persistence.relational;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
@Table(name = "Students")
public class Student {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "stu_id")
	private String studentId;

	@Column(name = "nm")
	private String name;

	@Email(message = "not valid email address format")
	private String email;

	private Date admittedDate;
}