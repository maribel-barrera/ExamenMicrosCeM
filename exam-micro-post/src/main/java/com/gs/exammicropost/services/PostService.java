package com.gs.exammicropost.services;

import java.sql.SQLException;
import java.util.List;

import com.gs.exammicropost.entities.Post;


public interface PostService {

	//READ
		List<Post> allPost() throws SQLException; 

		//CREAR
		void savePost(Post post) throws SQLException;

		//UPDATE
		void editPost(Post post) throws SQLException;
		
		//BUCAR BY ID
		Post findPostByID(int id_post) throws SQLException;

		//DELETE
		void deletePostByID(int id_post) throws SQLException;
}
