package com.hrtm.springboot.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Hibernate entity to represent Roles refers to user_roles table.
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */


@Entity
@Table(name = "user_roles")
public class UserRoles implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;

	
	private long roleId;
	
	private String roleName;
	
	private Set<User> users;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole")
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	@Column(name = "role_name", nullable = false)
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
