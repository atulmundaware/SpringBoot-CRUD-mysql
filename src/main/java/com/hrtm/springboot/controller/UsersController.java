package com.hrtm.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrtm.springboot.bo.UserBO;
import com.hrtm.springboot.model.User;
import com.hrtm.springboot.repository.UserRepository;
import com.hrtm.springboot.vo.UserVO;

/**
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */


@RestController
@RequestMapping("/user")
public class UsersController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserBO.class);
	
	@Autowired
	UserBO userBO;
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserVO userVO) {
		logger.info("Creating User : {}", userVO.getEmail());
		return new ResponseEntity<String>(userBO.saveUser(userVO), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userBO.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
		User user = userBO.findUserById(userId.longValue());
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByEmailId(@RequestParam(value = "email") String emailId) {
		User user = userBO.findUserByEmailId(emailId);
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserDetails(@RequestBody UserVO userVO) {
		return new ResponseEntity<String>(userBO.updateUser(userVO), HttpStatus.FOUND);
	}
	
}
