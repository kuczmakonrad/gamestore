package com.kk.gamestore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USER_ROLES")
public class UserRole {
	
	@Id
	@Column(name = "user_login_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_login")
	private String userLogin;
	
	@Column(name = "user_role")
	private String userRole;

	public UserRole (){
		super();
	}
	
	public String getUserRole(){
		return userRole;
	}
	
	public void setUserRole(String userRole){
		this.userRole = userRole;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

}
