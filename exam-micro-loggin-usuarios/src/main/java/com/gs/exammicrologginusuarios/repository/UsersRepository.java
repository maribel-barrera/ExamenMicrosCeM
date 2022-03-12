package com.gs.exammicrologginusuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gs.exammicrologginusuarios.entities.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{

}
