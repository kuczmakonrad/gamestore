package com.kk.gamestore.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kk.gamestore.domain.repository.UserRepository;
import com.kk.gamestore.service.UserService;
import com.kk.gamestore.domain.User;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public void setUserRepository(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	@Transactional
	public void addUser(User user){
		this.userRepository.addUser(user);
	}
	@Override
	@Transactional
	public void updateUser(User user) {
		this.userRepository.updateUser(user);
	}

	@Override
	@Transactional
	public List<User> userList() {
		return this.userRepository.userList();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userRepository.getUserById(id);
	}

	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		userRepository.deleteUser(user);
	}

}
