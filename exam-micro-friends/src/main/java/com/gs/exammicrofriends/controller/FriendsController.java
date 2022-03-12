package com.gs.exammicrofriends.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gs.exammicrofriends.entities.Friends;
import com.gs.exammicrofriends.services.FriendsServices;

@RestController
@RequestMapping()
public class FriendsController {

	@Autowired
	private FriendsServices _friendsService;
	
	@PostMapping("/createFriend")
	@ResponseStatus(CREATED)
	public  Friends createFriend(@RequestBody Friends friend, UriComponentsBuilder ucBuilder) throws SQLException {
		_friendsService.saveFriend(friend);
		return friend;

	}
	
	@GetMapping("/listFrinds")
	@ResponseStatus(OK)
	public List<Friends> leerFriends() {		
		try {
			List<Friends> allFriends = _friendsService.allFriends();
			return allFriends;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	

	
	@DeleteMapping("/deleteFrind/{id}")
	@ResponseStatus(OK)
	public void borrarFriend(@PathVariable("id") int id) throws SQLException {
		System.out.println("BORRAR ID = "+id);
		_friendsService.deleteFriendByID(id);
	}
	
}
