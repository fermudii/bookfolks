package com.generationc20.bookfolks.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String name;
	private String lastName;
	private Integer age;
	private String gender;
	private String description;
	private String password;
	private String email;
	private String urlImage;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime;
	
	public User() {}

	public User(Integer id, String username, String name, String lastName, Integer age, String gender, String description,
			String password, String email, String urlImage, Date creationDateTime) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.description = description;
		this.password = password;
		this.email = email;
		this.urlImage = urlImage;
		this.creationDateTime = creationDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Date getCreacionDateTime() {
		return creationDateTime;
	}

	public void setCreacionDateTime(Date creacionDateTime) {
		this.creationDateTime = creacionDateTime;
	}
	
	
}
