package com.hrtm.springboot.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrtm.springboot.exception.UserNotFoundException;
import com.hrtm.springboot.model.User;
import com.hrtm.springboot.model.UserDetails;
import com.hrtm.springboot.services.UserService;
import com.hrtm.springboot.util.CommonUtils;
import com.hrtm.springboot.vo.UserDetailsVO;
import com.hrtm.springboot.vo.UserVO;

/**
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

@Component
public class UserBO {

	@Autowired
	private UserService userService;
	
	private void fillUserDetails(UserVO userVO, User user) {
		BeanUtils.copyProperties(userVO, user);
		UserDetails userDetails = new UserDetails();
		BeanUtils.copyProperties(userVO.getUserDetails(), userDetails);
		user.setUserDetails(userDetails);
	}

	public User findUserById(long userId){
		User user = userService.findById(userId);
		if(user == null){
			throw new UserNotFoundException(userId);
		}
		return user;
	}
	
	public User findUserByEmailId(String emailId){

		User user = userService.findByEmail(emailId);
		if(user == null){
			throw new UserNotFoundException(emailId);
		}
		return user;
	}

	public String updateUser(UserVO userVO) {
		User user = userService.findByEmail(userVO.getEmail());
		if(user == null){
			throw new UserNotFoundException("");
		}
		BeanUtils.copyProperties(userVO, user, CommonUtils.getNullPropertyNames(userVO));
		user.setId(null);
		user.getUserDetails().setId(null);
		return userService.update(user);
	}

	public String saveUser(UserVO userVO) {
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		UserDetails userDetails = new UserDetails();
		fillUserWithUserDetails(user,userVO.getUserDetails(),userDetails);
		user.setUserDetails(userDetails);
		return userService.save(user);
	}
	
	private void fillUserWithUserDetails(User user, UserDetailsVO userDetailsVO, UserDetails userDetails) {
		BeanUtils.copyProperties(userDetailsVO, userDetails, CommonUtils.getNullPropertyNames(userDetailsVO));
		if (userDetailsVO.getProfilePhoto() != null) {
			userDetails.setProfilePhoto(userDetailsVO.getProfilePhoto());
		}
		userDetails.setMobileNo(userDetailsVO.getMobileNo());
		userDetails.setNickName(userDetailsVO.getNickName());
		userDetails.setCreatedDate(new Date());
		user.setUserDetails(userDetails);
		userDetails.setUser(user);
	}

	public List<User> findAllUsers() {
		return userService.findAll();
	}
	
}