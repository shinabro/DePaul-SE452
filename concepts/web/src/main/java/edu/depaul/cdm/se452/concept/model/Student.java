package edu.depaul.cdm.se452.concept.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private UUID id;
	
	@Column(name = "stu_id")
	private String studentId;

	@Column(name = "nm")
	private String name;

	private String email;

	private Date admittedDate = Date.valueOf(LocalDate.now());
}