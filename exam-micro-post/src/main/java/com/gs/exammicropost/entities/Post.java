package com.gs.exammicropost.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "post")
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_post")
	private int id_post;
	
	@Column(name = "id_user")
	private int id_user;
	
	@Column(name = "content_post")
	private String content_post;
	
	@Column(name = "date_post")
	private Date date_post;
	
	@Column(name = "num_likes")
	private int num_likes;
	
	@Column(name = "num_comments")
	private int num_comments;
	
	public int getId_post() {
		return id_post;
	}
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getContent_post() {
		return content_post;
	}
	public void setContent_post(String content_post) {
		this.content_post = content_post;
	}
	public Date getDate_post() {
		return date_post;
	}
	public void setDate_post(Date date_post) {
		this.date_post = date_post;
	}
	public int getNum_likes() {
		return num_likes;
	}
	public void setNum_likes(int num_likes) {
		this.num_likes = num_likes;
	}
	public int getNum_comments() {
		return num_comments;
	}
	public void setNum_comments(int num_comments) {
		this.num_comments = num_comments;
	}
	
}
