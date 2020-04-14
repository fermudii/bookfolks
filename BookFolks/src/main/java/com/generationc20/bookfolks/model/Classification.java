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
@Table(name= "classification")
public class Classification {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime;
	
	//Foreign keys
	private int id_story;
	private int id_genre;
	
	public Classification() {}

	public Classification(Integer id, int id_story, int id_genre, Date creationDateTime) {
		super();
		this.id = id;
		this.id_story = id_story;
		this.id_genre = id_genre;
		this.creationDateTime = creationDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getId_story() {
		return id_story;
	}

	public void setId_story(int id_story) {
		this.id_story = id_story;
	}

	public int getId_genre() {
		return id_genre;
	}

	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}
	
	public Date getCreacionDateTime() {
		return creationDateTime;
	}

	public void setCreacionDateTime(Date creacionDateTime) {
		this.creationDateTime = creacionDateTime;
	}

	
}

