package com.hawaya.socialnetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hawaya.socialnetwork.dao.UserRepository;
import com.hawaya.socialnetwork.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Page<User> getAllUsers(Pageable pageable) {
		return this.userRepository.findAll(pageable);

	}

	public User getUserByEmail(String email) {

		return this.userRepository.getUserByEmail(email);

	}

	public List<User> getUserByName(String name) {

		return this.userRepository.getUserByName(name);
	}

	public User findByEmailAndPassword(String email, String password) {

		return this.userRepository.findByEmailAndPassword(email, password);

	}

	public User findById(long id) {

		return this.userRepository.findById(id);

	}
	
	public User signUp(User user) {
		  
		  return userRepository.save(user);
		  
		  }
	
	
	
	/*
	 * public void addUser(User user) { this.userRepository.save(user); }
	 * 
	 * public User insertUser(User user) { boolean flag;
	 * 
	 * flag = alreadyRegistered(user.getEmail()); if (flag != true) {
	 * 
	 * return userRepository.save(user); //return "success"; } else { throw new
	 * CustomException("User is already registered",
	 * HttpStatus.UNPROCESSABLE_ENTITY); } }
	 * 
	 * public boolean alreadyRegistered(String email) {
	 * 
	 * return userRepository.existsByEmail(email);
	 * 
	 * }
	 * 
	 * public User fetchUserToken(String email) { User user;
	 * 
	 * boolean flag; flag = alreadyRegistered(email); if (flag) { return user =
	 * getUser(email); //return "success"; } else { throw new
	 * ResourceNotFoundException("User is not registered"); }
	 * 
	 * }
	 * 
	 * public User getUser(String email) {
	 * 
	 * User user; user = userRepository.findByEmail(email); return user; }
	 * /////////////////////////////////////////////////////////
	 * 
	 * @Transactional public User addUser(String firstName, String lastName, String
	 * email, String password) { User user =new User();
	 * user.setFirstName(firstName); user.setLastName(lastName);
	 * user.setEmail(email); user.setPassword(password); return
	 * userRepository.save(user); }
	 * 
	 * 
	 * 
	 * ////////////////////////////////////////////////////////
	 * ////////////////////////////////////////////////// 
	 * public User signUp(User user) {
	 * 
	 * return userRepository.save(user);
	 * 
	 * }
	 * 
	 * 
	 * //////////////////////////////////////////
	 * 
	 */

}
