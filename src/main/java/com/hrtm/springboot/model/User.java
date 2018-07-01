package com.hrtm.springboot.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Hibernate entity to represent user refers to user table.
 * 
 *  @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String email;
	
	private String password;

	private Character status;

	private Character isMailSent;
	
	private UserDetails userDetails;
	
	private Date createdDate;

	private Date lastLoginDate;

	private UserRoles userRole;
	
	private User addedBy;
	
	private Set<User> addedUsers;
	
	private Character isFirstTimeUser;
	
	@Column(name = "is_first_time_login")
	public Character getIsFirstTimeUser() {
		return isFirstTimeUser;
	}

	public void setIsFirstTimeUser(Character isFirstTimeUser) {
		this.isFirstTimeUser = isFirstTimeUser;
	}

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="added_by")
	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "addedBy")
	public Set<User> getAddedUsers() {
		return addedUsers;
	}

	public void setAddedUsers(Set<User> addedUsers) {
		this.addedUsers = addedUsers;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public UserRoles getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "email", unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "status", nullable = false)
	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}
	
	@Column(name = "is_mail_sent")
	public Character getIsMailSent() {
		return isMailSent;
	}

	public void setIsMailSent(Character isMailSent) {
		this.isMailSent = isMailSent;
	}


	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "last_login_date")
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	
}
