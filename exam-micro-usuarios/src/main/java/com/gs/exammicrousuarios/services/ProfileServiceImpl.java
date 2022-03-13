package com.gs.exammicrousuarios.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.exammicrousuarios.dao.ProfileRepository;
import com.gs.exammicrousuarios.entities.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository _profileRepository;
	
	@Override
	public List<Profile> findAllProfiles() throws SQLException {
		return (List<Profile>) _profileRepository.findAll();
	}

	@Override
	public void saveProfile(Profile profile) throws SQLException {
		_profileRepository.save(profile);
	}

	@Override
	public void editUser(Profile profile) throws SQLException {
		_profileRepository.save(profile);
	}

	@Override
	public Profile findUserByID(int id_profile) throws SQLException {
		Optional<Profile> profileFind = _profileRepository.findById(id_profile);
		Optional<Profile> map = profileFind.map(Profile.class::cast);
		Profile userFindOK = map.get();
		return userFindOK;
	}

	@Override
	public void deleteProfileByID(int id_profile) throws SQLException {
		_profileRepository.deleteById(id_profile);
	}

	
}
