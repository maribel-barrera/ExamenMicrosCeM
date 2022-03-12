package com.gs.exammicropost.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gs.exammicropost.entities.Post;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{

}
