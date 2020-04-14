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
@Table(name= "image")
public class Image {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String path;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime;
	
	//Foreign keys
	private int id_continuity;
	private int id_chapter;
	
	public Image() {}

	public Image(Integer id, String name, String path, int id_continuity, int id_chapter, Date creationDateTime) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.id_continuity = id_continuity;
		this.id_chapter = id_chapter;
		this.creationDateTime = creationDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getId_continuity() {
		return id_continuity;
	}

	public void setId_continuity(int id_continuity) {
		this.id_continuity = id_continuity;
	}

	public int getId_chapter() {
		return id_chapter;
	}

	public void setId_chapter(int id_chapter) {
		this.id_chapter = id_chapter;
	}
	
	public Date getCreacionDateTime() {
		return creationDateTime;
	}

	public void setCreacionDateTime(Date creacionDateTime) {
		this.creationDateTime = creacionDateTime;
	}
	
	
}
