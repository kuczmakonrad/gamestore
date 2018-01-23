package com.kk.gamestore.domain.repository;

import java.util.List;

import com.kk.gamestore.domain.UserRole;

public interface UserRoleRepository {
	public void addUserRole(UserRole role);
	UserRole getUserRoleByUserId(String userId);
	void deleteUserRole(UserRole userRole);
	List<UserRole> getAllRoles();
}
