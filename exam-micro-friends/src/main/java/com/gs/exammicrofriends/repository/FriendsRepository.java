package com.gs.exammicrofriends.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gs.exammicrofriends.entities.Friends;

@Repository
public interface FriendsRepository extends CrudRepository<Friends, Integer>{

}
