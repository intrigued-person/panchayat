package com.shakeel.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakeel.model.User;
import com.shakeel.repos.UserRepoImp;
import com.shakeel.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserImp implements UserService {

	@Autowired
	private UserRepoImp service;

	@Override
	public void addUser(User user) {
		service.addUser(user);

	}

	@Override
	public void delUser(int id) {
		service.delUser(id);

	}

	@Override
	public void updateUser(User user) {
		service.updateUser(user);

	}

	@Override
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@Override
	public User findById(int id) {
		return service.findById(id);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return service.findByEmail(email);
	}

	@Override
	public User Login(String email, String password) {
		User user = null;
		try {
			user = service.Login(email, password);
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

}
