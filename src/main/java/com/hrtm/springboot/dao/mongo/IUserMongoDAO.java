package com.hrtm.springboot.dao.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hrtm.springboot.model.mongo.UserMongo;

@RepositoryRestResource(collectionResourceRel = "users")
public interface IUserMongoDAO extends MongoRepository<UserMongo, String>{
	
	public UserMongo findByEmail(String email);
	public UserMongo findById(String id);
}
