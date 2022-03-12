package com.gs.exammicrocomments.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gs.exammicrocomments.entities.Comments;


@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer> {

}
