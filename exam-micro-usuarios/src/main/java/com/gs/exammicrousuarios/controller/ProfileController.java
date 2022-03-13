package com.gs.exammicrousuarios.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gs.exammicrousuarios.entities.Profile;
import com.gs.exammicrousuarios.services.ProfileService;

@RestController
@RequestMapping()
public class ProfileController {

	@Autowired
	private ProfileService _profileService;
	
	@PostMapping("/createProfile")
	@ResponseStatus(CREATED)
	public Profile creteProfile(@RequestBody Profile profile, UriComponentsBuilder ucBuilder) throws SQLException {
		_profileService.saveProfile(profile);		
		return profile;
	}

	
	@GetMapping("/listProfile")
	@ResponseStatus(OK)
	public List<Profile> leerPersonas() {		
		try {
			List<Profile> allProfile = _profileService.findAllProfiles();
			return allProfile;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	
	@PutMapping("/updateProfile/{id}")
	@ResponseStatus(OK)
	public void editarPersona(@RequestBody Profile profile, @PathVariable int id) throws SQLException {
		Profile userEdit = _profileService.findUserByID(id);
		userEdit.setName(profile.getName());
		userEdit.setLast_name(profile.getLast_name());
		userEdit.setAge(profile.getAge());
		userEdit.setDate_of_birth(profile.getDate_of_birth());
		userEdit.setPhone_number(profile.getPhone_number());
		userEdit.setEmail(profile.getEmail());
		System.out.println("EDITAR ID = "+id);
		_profileService.saveProfile(userEdit);
	}
	
	
	@DeleteMapping("/deleteProfile/{id}")
	@ResponseStatus(OK)
	public void borrarPersona(@PathVariable("id") int id) throws SQLException {
		System.out.println("BORRAR ID = "+id);
		_profileService.deleteProfileByID(id);
	}

	
}
