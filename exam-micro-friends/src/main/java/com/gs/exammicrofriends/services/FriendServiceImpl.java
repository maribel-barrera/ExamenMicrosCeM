package com.gs.exammicrofriends.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.exammicrofriends.entities.Friends;
import com.gs.exammicrofriends.repository.FriendsRepository;

@Service
public class FriendServiceImpl implements FriendsServices {

	@Autowired
	private FriendsRepository _friendsRepository;
	
	@Override
	public List<Friends> allFriends() throws SQLException {
		return (List<Friends>) _friendsRepository.findAll();
	}

	@Override
	public void saveFriend(Friends friend) throws SQLException {
		_friendsRepository.save(friend);
	}

	@Override
	public void editFriend(Friends friend) throws SQLException {
		_friendsRepository.save(friend);
	}

	@Override
	public Friends findFriendByID(int id_friend) throws SQLException {
		Optional<Friends> friendFind = _friendsRepository.findById(id_friend);
		Optional<Friends> map = friendFind.map(Friends.class::cast);
		Friends frindOK = map.get();
		return frindOK;
	}

	@Override
	public void deleteFriendByID(int id_friend) throws SQLException {
		_friendsRepository.deleteById(id_friend);
	}

}
