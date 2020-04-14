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
@Table(name= "version")
public class Version {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creacionDateTime;
	
	//Foreign keys
	private int id_continuity;
	private int id_chapter;
	
	
	public Version() {}

	public Version(Integer id, int id_continuity, int id_chapter,Date creationDateTime) {
		super();
		this.id = id;
		this.id_continuity = id_continuity;
		this.id_chapter = id_chapter;
		this.creacionDateTime = creationDateTime;
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

	public int getId_chapter() {
		return id_chapter;
	}

	public void setId_chapter(int id_chapter) {
		this.id_chapter = id_chapter;
	}
	
	public Date getCreacionDateTime() {
		return creacionDateTime;
	}

	public void setCreacionDateTime(Date creacionDateTime) {
		this.creacionDateTime = creacionDateTime;
	}

	
}
