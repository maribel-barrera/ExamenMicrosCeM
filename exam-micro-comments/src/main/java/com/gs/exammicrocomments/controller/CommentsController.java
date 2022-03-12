package com.gs.exammicrocomments.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gs.exammicrocomments.entities.Comments;
import com.gs.exammicrocomments.service.CommentsService;

@RestController
@RequestMapping()
public class CommentsController {
	
	@Autowired
	private CommentsService _commentsService;
	
	@PostMapping("/createComment")
	@ResponseStatus(CREATED)
	public  Comments createPost(@RequestBody Comments comment, UriComponentsBuilder ucBuilder) throws SQLException {
		_commentsService.saveComment(comment);
		return comment;

	}
	
	@GetMapping("/listComment")
	@ResponseStatus(OK)
	public List<Comments> leerComments() {		
		try {
			List<Comments> allComments = _commentsService.allComments();
			return allComments;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	@PutMapping("/updateComment/{id}")
	@ResponseStatus(OK)
	public void editarComment(@RequestBody Comments comment2Edit, @PathVariable int id) throws SQLException {
		Comments comment = _commentsService.findCommentByID(id);
		comment.setContent_image(comment2Edit.getContent_image());
		comment.setContent_text(comment2Edit.getContent_text());
		comment.setDate_comment(comment2Edit.getDate_comment());
		
		System.out.println("EDITAR ID = "+id);
		_commentsService.saveComment(comment);
	}
	
	@DeleteMapping("/deleteComment/{id}")
	@ResponseStatus(OK)
	public void borrarComment(@PathVariable("id") int id) throws SQLException {
		System.out.println("BORRAR ID = "+id);
		_commentsService.deleteCommentByID(id);
	}
	
}
