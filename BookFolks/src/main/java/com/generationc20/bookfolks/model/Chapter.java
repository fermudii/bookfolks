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
@Table(name= "chapter")
public class Chapter {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private int id_continuity;
	private String title;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime;
	
	//Foreign Keys
	private int id_user;
	private int id_story;
	private int id_image;
	
	public Chapter() {}

	public Chapter(Integer id, int id_continuity, String title, String content, int id_user, int id_story,
			int id_image, Date creationDateTime) {
		super();
		this.id = id;
		this.id_continuity = id_continuity;
		this.title = title;
		this.content = content;
		this.id_user = id_user;
		this.id_story = id_story;
		this.id_image = id_image;
		this.creationDateTime = creationDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getId_continuity() {
		return id_continuity;
	}

	public void setId_continuity(int id_continuity) {
		this.id_continuity = id_continuity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_story() {
		return id_story;
	}

	public void setId_story(int id_story) {
		this.id_story = id_story;
	}

	public int getId_image() {
		return id_image;
	}

	public void setId_image(int id_image) {
		this.id_image = id_image;
	}
	
	public Date getCreacionDateTime() {
		return creationDateTime;
	}

	public void setCreacionDateTime(Date creacionDateTime) {
		this.creationDateTime = creacionDateTime;
	}

	
}
