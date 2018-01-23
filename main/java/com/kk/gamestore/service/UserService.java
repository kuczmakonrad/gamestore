package com.kk.gamestore.service;

import java.util.List;

import com.kk.gamestore.domain.User;

public interface UserService {
	public void addUser(User user);
	public void updateUser(User user);
	public List<User> userList();
	public User getUserById(int id);
	public void deleteUser(User user);
	
}
