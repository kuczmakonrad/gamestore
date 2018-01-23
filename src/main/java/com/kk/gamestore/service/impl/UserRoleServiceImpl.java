package com.kk.gamestore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.kk.gamestore.domain.UserRole;

import com.kk.gamestore.domain.repository.UserRoleRepository;
import com.kk.gamestore.service.UserRoleService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserRoleServiceImpl implements UserRoleService{


	@Autowired
	private UserRoleRepository userRoleRepository;
	

	@Transactional(readOnly = false)
	public void addUserRole(UserRole role) {
		userRoleRepository.addUserRole(role);
	}
	
	@Transactional
	public UserRole getUserRoleByUserId(String userId){
		return userRoleRepository.getUserRoleByUserId(userId);
	}

	@Transactional(readOnly = false)
	public void deleteUserRole(UserRole userRole) {
		userRoleRepository.deleteUserRole(userRole);
		
	}
	@Transactional
	public List<UserRole> getAllRoles() {
		return userRoleRepository.getAllRoles();
	}
}
