package com.hrtm.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hrtm.springboot.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByEmail(String email);
	public User findById(long id);
	public List<User> findAll();	
}
