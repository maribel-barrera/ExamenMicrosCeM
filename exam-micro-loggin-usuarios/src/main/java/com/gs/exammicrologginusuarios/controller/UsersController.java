package com.gs.exammicrologginusuarios.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gs.exammicrologginusuarios.entities.Users;
import com.gs.exammicrologginusuarios.services.UserService;

@RestController
@RequestMapping()
public class UsersController {
	
	@Autowired
	private UserService _userService;
	
	@PostMapping("/createUser")
	public  ResponseEntity<?> creteUser(@RequestBody Users user, UriComponentsBuilder ucBuilder) throws SQLException {
		HttpHeaders headers = new HttpHeaders();
		_userService.saveUser(user);
		
		headers.setLocation(ucBuilder.path("/createUser/{id}").buildAndExpand(user.getId_user()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	
	@GetMapping("/listUsers")
	public List<Users> leerPersonas() {		
		try {
			List<Users> allUsers = _userService.findAllUsers();
			return allUsers;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	
	@PutMapping("/updateUser/{id}")
	public void editarPersona(@RequestBody Users user, @PathVariable int id) throws SQLException {
		Users userEdit = _userService.findUserByID(id);
		userEdit.setUser_name(user.getUser_name());
		userEdit.setPassword(user.getPassword());
		System.out.println("EDITAR ID = "+id);
		_userService.saveUser(userEdit);
	}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public void borrarPersona(@PathVariable("id") int id) throws SQLException {
		System.out.println("BORRAR ID = "+id);
		_userService.deleteUserByID(id);
	}

	
}
