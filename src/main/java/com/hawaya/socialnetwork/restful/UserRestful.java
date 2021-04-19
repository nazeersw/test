package com.hawaya.socialnetwork.restful;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;

import com.hawaya.socialnetwork.entity.User;
import com.hawaya.socialnetwork.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserRestful {
	@Autowired
	UserService userService;

	/**
	 * get all users
	 * 
	 * @param pageable
	 * @return list of users
	 */
	// call like this :http://localhost:8080/api/users
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public Page<User> getAllUsers(Pageable pageable) {
		return this.userService.getAllUsers(pageable);
	}

	/**
	 * find user by email
	 * 
	 * @param email
	 * @return existed user
	 */
	// call like this :http://localhost:8080/api/users/email/...
	@RequestMapping(method = RequestMethod.GET, value = "/users/email/{email}")
	public User getUserByEmail(@PathVariable(value = "email") String email) {
		return this.userService.getUserByEmail(email);
	}

	/**
	 * find user by name
	 * 
	 * @param name
	 * @return list of user
	 */
	// call like this :http://localhost:8080/api/users/name/...
	@RequestMapping(method = RequestMethod.GET, value = "/users/name/{name}")
	public List<User> getUserByName(@PathVariable(value = "name") String name) {
		return this.userService.getUserByName(name);
	}

	/**
	 * Create a User.
	 * 
	 * @param user data transfer object
	 */
	@PostMapping("/users/signup")
	public User signUp(@RequestBody @Validated User user)

	{

		return userService.signUp(user);

	}

	/**
	 * signin
	 * 
	 * @param u {username,password}
	 * @return User
	 */
	@PostMapping("/users/signin")
	public User getUser(@RequestBody Map<String, String> u) {

		return userService.findByEmailAndPassword(u.get("email"), u.get("password"));

	}

}
