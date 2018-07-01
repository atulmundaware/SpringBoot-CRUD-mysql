package com.hrtm.springboot.vo;

/**
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

public class UserVO {
	
	private String id;
	private String email;
	private String password;
	
	private UserDetailsVO userDetails;

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
	public UserDetailsVO getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetailsVO userDetailsVO) {
		this.userDetails = userDetailsVO;
	}
	
}
