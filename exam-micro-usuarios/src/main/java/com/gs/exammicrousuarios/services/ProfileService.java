package com.gs.exammicrousuarios.services;

import java.sql.SQLException;
import java.util.List;

import com.gs.exammicrousuarios.entities.Profile;

public interface ProfileService {

	//READ
	List<Profile> findAllProfiles() throws SQLException; 

	//CREAR
	void saveProfile(Profile profile) throws SQLException;

	//UPDATE
	void editUser(Profile profile) throws SQLException;
	
	//BUCAR BY ID
	Profile findUserByID(int id_profile) throws SQLException;

	//DELETE
	void deleteProfileByID(int id_profile) throws SQLException;

}
