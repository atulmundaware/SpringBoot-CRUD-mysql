package com.hrtm.springboot.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */


@Document(collection = "users")
public class UserMongo {

	@Id
	private String id;

	@Indexed(unique = true)
	private String email;
	
	private String password;
	
	private UserDetailsMongo userDetails;
	
	
	public UserMongo() {
		id = null;
	}

	public UserDetailsMongo getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsMongo userDetails) {
		this.userDetails = userDetails;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMongo other = (UserMongo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", userDetails=" + userDetails + "]";
	}

	
	
	

}
