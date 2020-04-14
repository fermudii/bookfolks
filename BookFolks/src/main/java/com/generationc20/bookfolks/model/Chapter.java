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
	private String author;
	private String storyTitle;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime;
	
	//Foreign Keys
	private int id_user;
	private int id_story;
	private String urlImage;
	
	public Chapter() {}

	public Chapter(Integer id, int id_continuity, String title, String content,String author, String storyTitle, int id_user, int id_story,
			String urlImage, Date creationDateTime) {
		super();
		this.id = id;
		this.id_continuity = id_continuity;
		this.title = title;
		this.content = content;
		this.author = author;
		this.storyTitle = storyTitle;
		this.id_user = id_user;
		this.id_story = id_story;
		this.urlImage = urlImage;
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
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getStoryTitle() {
		return storyTitle;
	}
	
	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
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
