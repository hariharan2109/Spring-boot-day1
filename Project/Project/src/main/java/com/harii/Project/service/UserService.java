package com.harii.Project.service;

import java.util.List;

import com.harii.Project.model.User;

public interface UserService {
	public boolean addUser(User user);
	public List<User> getUser();
	public boolean updateUser(Long id,User user);
	public boolean deleteUser(Long id);
}
