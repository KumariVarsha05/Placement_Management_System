package com.PlacementManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificate")
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "year")
	private String year;

	@Column(name = "college")
	private String college;

	

	public Certificate() {
	}

	public Certificate(String year, String college) {

		this.year = year;
		this.college = college;
		

	}

	public Certificate(int id, String year, String college) {
		this.id = id;
		this.year = year;
		this.college = college;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	

}
