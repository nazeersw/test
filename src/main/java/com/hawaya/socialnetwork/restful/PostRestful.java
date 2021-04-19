package com.hawaya.socialnetwork.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hawaya.socialnetwork.entity.Post;
import com.hawaya.socialnetwork.service.PostService;
import com.hawaya.socialnetwork.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class PostRestful {
	@Autowired
	PostService postService;

	@Autowired
	UserService userService;

	/**
	 * get all post
	 * 
	 * @return
	 */
	// call like this :http://localhost:8080/api/posts
	@RequestMapping(method = RequestMethod.GET, value = "/posts")
	public List<Post> getAllPost() {
		return this.postService.getAllPost();
	}

	/**
	 * get post for selected userId
	 * 
	 * @param id
	 * @return post
	 */
	// call like this :http://localhost:8080/api/posts/id
	@RequestMapping(method = RequestMethod.GET, value = "/posts/{id}")
	public List<Post> getPostByUserId(@PathVariable(value = "id") Long id) {
		return this.postService.getPostByUserId(id);

	}

	/**
	 * add post for selected user id
	 * 
	 * @param post   data transfer object
	 * @param userid
	 * @return
	 */
	@PostMapping("/posts/{userid}")
	public Post addPost(@RequestBody Post post, @PathVariable(value = "userid") Long userid)

	{
		post.setUser(userService.findById(userid));

		return this.postService.inser(post);

	}

}
