package com.formapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formapp.model.User;
import com.formapp.repository.UserRepository;

@Service("userService")

public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository;


	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}


	public List<User> findByExample(User user) {

		List<User> list = new ArrayList<User>();
		list.addAll(userRepository.findAll());
		
//		userRepo.findUserByExample(user);

		System.out.println("listado: " + list.size());
		return list;
	}
}
