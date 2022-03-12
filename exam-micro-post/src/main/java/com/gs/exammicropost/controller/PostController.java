package com.gs.exammicropost.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gs.exammicropost.entities.Post;
import com.gs.exammicropost.services.PostService;

@RestController
@RequestMapping()
public class PostController {

	@Autowired
	private PostService _postService;
	
	@PostMapping("/createPost")
	public  ResponseEntity<?> createPost(@RequestBody Post post, UriComponentsBuilder ucBuilder) throws SQLException {
		HttpHeaders headers = new HttpHeaders();
		_postService.savePost(post);
		
		headers.setLocation(ucBuilder.path("/createPost/{id}").buildAndExpand(post.getId_post()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}
	
	@GetMapping("/listPost")
	public List<Post> leerPost() {		
		try {
			List<Post> allPost = _postService.allPost();
			return allPost;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	@PutMapping("/updatePost/{id}")
	public void editarPost(@RequestBody Post post2Edit, @PathVariable int id) throws SQLException {
		Post post = _postService.findPostByID(id);
		post.setContent_post(post2Edit.getContent_post());
		post.setDate_post(new Date());
		System.out.println("EDITAR ID = "+id);
		_postService.savePost(post);
	}
	
	@DeleteMapping("/deletePost/{id}")
	public void borrarPost(@PathVariable("id") int id) throws SQLException {
		System.out.println("BORRAR ID = "+id);
		_postService.deletePostByID(id);
	}

}
