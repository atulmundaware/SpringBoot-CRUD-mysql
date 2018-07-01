package com.hrtm.springboot.bo.mongo;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrtm.springboot.dao.mongo.IUserMongoDAO;
import com.hrtm.springboot.exception.UserAlreadyExistsException;
import com.hrtm.springboot.exception.UserNotFoundException;
import com.hrtm.springboot.model.mongo.UserMongo;
import com.hrtm.springboot.model.mongo.UserDetailsMongo;
import com.hrtm.springboot.util.CommonUtils;
import com.hrtm.springboot.vo.UserVO;

/**
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

@Component
public class UserMongoBO {

	@Autowired
	IUserMongoDAO userDAO;
	
	public String saveUser(UserVO userVO) {
		if (userDAO.findByEmail(userVO.getEmail()) != null) {
		    throw new UserAlreadyExistsException(userVO.getEmail());
		}
		try{
			UserMongo user = new UserMongo();
//			BeanUtils.copyProperties(userVO, user);
			fillUserDetails(userVO,user);
			return userDAO.insert(user).getId();
		}finally{
			userVO = null;
		}
	}

	private void fillUserDetails(UserVO userVO, UserMongo user) {
		BeanUtils.copyProperties(userVO, user);
		UserDetailsMongo userDetails = new UserDetailsMongo();
		BeanUtils.copyProperties(userVO.getUserDetails(), userDetails);
		user.setUserDetails(userDetails);
	}

	public List<UserMongo> findAllUsers() {
		return userDAO.findAll();
	}
	
	public UserMongo findUserById(String userId){
		UserMongo user = userDAO.findOne(userId);
		if(user == null){
			throw new UserNotFoundException(userId);
		}
		return user;
	}
	
	public UserMongo findUserByEmailId(String emailId){

		UserMongo user = userDAO.findByEmail(emailId);
		if(user == null){
			throw new UserNotFoundException(emailId);
		}
		return user;
	}

	public UserMongo updateUser(UserVO userVO) {
		UserMongo user = userDAO.findByEmail(userVO.getEmail());
		if(user == null){
			throw new UserNotFoundException("");
		}
		BeanUtils.copyProperties(userVO, user, CommonUtils.getNullPropertyNames(userVO));
		user = userDAO.save(user);
		return user;
	}
	
}