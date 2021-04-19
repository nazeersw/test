package com.hawaya.socialnetwork.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.hawaya.socialnetwork.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// check if user exist

	// this:http://localhost:8080/users/search/findByEmailAndPassword?email=...&password=...
	User findByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password);

	// search user by email
	// call like this http://localhost:8080/users/search/getUserByEmail?email=...
	@Query("select u from User u where u.email=:email")
	User getUserByEmail(@RequestParam("email") String email);

	// search user by firstname
	// call like this
	// http://localhost:8080/users/search/getUserByName?firstName=....
	@Query("select u from User u where u.firstName=:firstName")
	List<User> getUserByName(@RequestParam("firstName") String firstName);

	boolean existsByEmail(String username);

	User findByEmail(String email);

	User findById(@RequestParam("id") long id);

}
