package com.kk.gamestore.service;

import java.util.List;

import com.kk.gamestore.domain.UserRole;

public interface UserRoleService {
	public void addUserRole(UserRole role);
	UserRole getUserRoleByUserId(String userId);
	void deleteUserRole(UserRole userRole);
	List<UserRole> getAllRoles();

}