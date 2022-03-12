package com.gs.exammicrocomments.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.exammicrocomments.dao.CommentsRepository;
import com.gs.exammicrocomments.entities.Comments;

@Service
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	private CommentsRepository _commentRepository;

	@Override
	public List<Comments> allComments() throws SQLException {
		return (List<Comments>) _commentRepository.findAll();
	}

	@Override
	public void saveComment(Comments comment) throws SQLException {
		_commentRepository.save(comment);
	}

	@Override
	public void editComment(Comments comment) throws SQLException {
		_commentRepository.save(comment);
	}

	@Override
	public Comments findCommentByID(int id_comment) throws SQLException {
		Optional<Comments> commentFind = _commentRepository.findById(id_comment);
		Optional<Comments> map = commentFind.map(Comments.class::cast);
		Comments commentOk = map.get();
		return commentOk;
	}

	@Override
	public void deleteCommentByID(int id_comment) throws SQLException {
		_commentRepository.deleteById(id_comment);
	}

}
