package com.hrtm.springboot.services;

import java.security.SecureRandom;
import java.util.List;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.hrtm.springboot.model.User;
import com.hrtm.springboot.repository.UserRepository;

@Service
public class UserService {

	
    @Autowired
    private UserRepository userRepo;

//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    
    public String save(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        if(userRepo.save(user) != null){
        	return "User " + user.getEmail() + " Created successfully...";
        }else{
        	return "Can not create user : "+ user.getEmail();
        }
    }
    
    public String update(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        if(userRepo.save(user) != null){
        	return "User " + user.getEmail() + " Updated successfully...";
        }else{
        	return "Can not Updated user : "+ user.getEmail();
        }
    }

	public User findById(long userId) {
		return userRepo.findById(userId);
	}

	public User findByEmail(String emailId) {
		return userRepo.findByEmail(emailId);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}
}
