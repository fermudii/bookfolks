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
@Table(name= "genre")
public class Genre {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String genre_name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime;
	
	public Genre() {}

	public Genre(Integer id, String genre_name, Date creationDateTime) {
		super();
		this.id = id;
		this.genre_name = genre_name;
		this.creationDateTime = creationDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	
	public Date getCreacionDateTime() {
		return creationDateTime;
	}

	public void setCreacionDateTime(Date creacionDateTime) {
		this.creationDateTime = creacionDateTime;
	}
	
	
}
