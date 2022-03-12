package com.gs.exammicrofriends.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
public class Friends implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_friends")
	private int id_friends;
	
	@Column(name = "id_user_sender")
	private int id_user_sender;
	
	@Column(name = "id_user_receptor")
	private int id_user_receptor;
	
	@Column(name = "date_request")
	private Date date_request;
	
	public int getId_friends() {
		return id_friends;
	}
	public void setId_friends(int id_friends) {
		this.id_friends = id_friends;
	}
	public int getId_user_sender() {
		return id_user_sender;
	}
	public void setId_user_sender(int id_user_sender) {
		this.id_user_sender = id_user_sender;
	}
	public int getId_user_receptor() {
		return id_user_receptor;
	}
	public void setId_user_receptor(int id_user_receptor) {
		this.id_user_receptor = id_user_receptor;
	}
	public Date getDate_request() {
		return date_request;
	}
	public void setDate_request(Date date_request) {
		this.date_request = date_request;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
