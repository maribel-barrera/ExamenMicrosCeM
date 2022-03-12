package com.gs.exammicropost.entities;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.exammicropost.dao.PostRepository;
import com.gs.exammicropost.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository _postRepository;
	
	@Override
	public List<Post> allPost() throws SQLException {
		return (List<Post>) _postRepository.findAll();
	}

	@Override
	public void savePost(Post post) throws SQLException {
		_postRepository.save(post);
	}

	@Override
	public void editPost(Post post) throws SQLException {
		_postRepository.save(post);
	}

	@Override
	public Post findPostByID(int id_post) throws SQLException {
		Optional<Post> postFind = _postRepository.findById(id_post);
		Optional<Post> map = postFind.map(Post.class::cast);
		Post postFindOK = map.get();
		return postFindOK;
	}

	@Override
	public void deletePostByID(int id_post) throws SQLException {
		_postRepository.deleteById(id_post);
	}

}
