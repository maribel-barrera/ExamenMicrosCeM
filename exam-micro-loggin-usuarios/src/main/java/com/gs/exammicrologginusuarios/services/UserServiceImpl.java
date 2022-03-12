package com.gs.exammicrologginusuarios.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.exammicrologginusuarios.repository.UsersRepository;
import com.gs.exammicrologginusuarios.entities.Users;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository _userRepository;

	@Override
	public List<Users> findAllUsers() throws SQLException {
		return (List<Users>) _userRepository.findAll();
	}

	@Override
	public void saveUser(Users user) throws SQLException {
		_userRepository.save(user);
	}

	@Override
	public void editUser(Users user) throws SQLException {
		_userRepository.save(user);
	}

	@Override
	public Users findUserByID(int id_user) throws SQLException {
		Optional<Users> userFind = _userRepository.findById(id_user);
		Optional<Users> map = userFind.map(Users.class::cast);
		Users userFindOK = map.get();
		return userFindOK;
	}

	@Override
	public void deleteUserByID(int id_user) throws SQLException {
		_userRepository.deleteById(id_user);
	}

}
