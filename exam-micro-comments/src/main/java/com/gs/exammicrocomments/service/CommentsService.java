package com.gs.exammicrocomments.service;

import java.sql.SQLException;
import java.util.List;

import com.gs.exammicrocomments.entities.Comments;


public interface CommentsService {

	//READ
	List<Comments> allComments() throws SQLException; 

	//CREAR
	void saveComment(Comments comment) throws SQLException;

	//UPDATE
	void editComment(Comments comment) throws SQLException;
	
	//BUCAR BY ID
	Comments findCommentByID(int id_comment) throws SQLException;

	//DELETE
	void deleteCommentByID(int id_comment) throws SQLException;
}
