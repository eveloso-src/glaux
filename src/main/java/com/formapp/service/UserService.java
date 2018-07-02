package com.formapp.service;

import java.util.List;

import com.formapp.model.User;

public interface UserService {
//	public User findUserByEmail(String email);
	public void saveUser(User user);
//	public List<User> findAll();
	public List<User> findByExample(User user);
}
