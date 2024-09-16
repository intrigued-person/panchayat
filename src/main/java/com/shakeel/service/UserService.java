package com.shakeel.service;

import java.util.List;
import java.util.Optional;

import com.shakeel.model.User;

public interface UserService {

	public void addUser(User user);

	public void delUser(int id);

	public void updateUser(User user);

	public List<User> getAllUsers();

	public User findById(int id);

	public Optional<User> findByEmail(String email);

	public User Login(String email, String password);

}
