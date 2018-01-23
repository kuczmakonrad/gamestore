
package com.kk.gamestore.domain.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kk.gamestore.domain.UserRole;
import com.kk.gamestore.domain.repository.UserRoleRepository;
import com.kk.gamestore.service.UserService;

@Repository
public class InMemoryUserRoleRepository implements UserRoleRepository{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	public void addUserRole(UserRole role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(role);
	}

	
	public UserRole getUserRoleByUserId(String userId) {
		int id = Integer.valueOf(userId);
		UserRole userRole = new UserRole();
		List<UserRole> roleList = getAllRoles();
		for (UserRole ur : roleList) {
			if(ur.getUserLogin().equals(userService.getUserById(id).getUserLogin())) {
				userRole = ur;
				break;
			}
		}
		return userRole;
	}
	

	public void deleteUserRole(UserRole userRole) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(userRole);
	}


	public List<UserRole> getAllRoles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UserRole> roleList = session.createQuery("from UserRole").list();
		return roleList;
	}
	

}
