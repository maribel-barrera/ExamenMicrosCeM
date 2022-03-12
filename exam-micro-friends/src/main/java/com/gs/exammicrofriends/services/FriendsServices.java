package com.gs.exammicrofriends.services;

import java.sql.SQLException;
import java.util.List;

import com.gs.exammicrofriends.entities.Friends;

public interface FriendsServices {

	//READ
	List<Friends> allFriends() throws SQLException; 

	//CREAR
	void saveFriend(Friends friend) throws SQLException;

	//UPDATE
	void editFriend(Friends friend) throws SQLException;
	
	//BUCAR BY ID
	Friends findFriendByID(int id_friend) throws SQLException;

	//DELETE
	void deleteFriendByID(int id_friend) throws SQLException;
}
