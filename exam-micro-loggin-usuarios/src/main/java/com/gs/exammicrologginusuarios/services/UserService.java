package com.gs.exammicrologginusuarios .services;

import java.sql.SQLException;
import java.util.List;

import com.gs.exammicrologginusuarios.entities.Users;

public interface UserService {

	//READ
	List<Users> findAllUsers() throws SQLException; 

	//CREAR
	void saveUser(Users user) throws SQLException;

	//UPDATE
	void editUser(Users user) throws SQLException;
	
	//BUCAR BY ID
	Users findUserByID(int id_user) throws SQLException;

	//DELETE
	void deleteUserByID(int id_user) throws SQLException;

}
