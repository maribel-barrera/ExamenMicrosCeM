package com.gs.exammicrocomments.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comment")
	private int id_comment;
	
	@Column(name = "id_user")
	private int id_user;
	
	@Column(name = "content_text")
	private String content_text;
	
	@Column(name = "content_image")
	private String content_image;
	
	@Column(name = "date_comment")
	private Date date_comment;
	
	public int getId_comment() {
		return id_comment;
	}
	public void setId_comment(int id_comment) {
		this.id_comment = id_comment;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getContent_text() {
		return content_text;
	}
	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}
	public String getContent_image() {
		return content_image;
	}
	public void setContent_image(String content_image) {
		this.content_image = content_image;
	}
	public Date getDate_comment() {
		return date_comment;
	}
	public void setDate_comment(Date date_comment) {
		this.date_comment = date_comment;
	}
	
}
