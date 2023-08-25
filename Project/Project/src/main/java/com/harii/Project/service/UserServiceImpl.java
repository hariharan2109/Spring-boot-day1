package com.harii.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harii.Project.model.User;
import com.harii.Project.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public boolean addUser(User user) {
		boolean userExists = userRepository.existsByEmail(user.getEmail());
		if(!userExists)
		{
			userRepository.save(user);
			return true;
		}
		else 
		{
			return false;
		}
	}

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}
	
	@Override
	public boolean updateUser(Long id, User user) {
		Optional<User> existingUserOptional = userRepository.findById(id);
		if(existingUserOptional.isPresent())
		{
			User userExists = existingUserOptional.get();
			userExists.setChefname(user.getChefname());
			userExists.setEmail(user.getEmail());
			userExists.setEmployees(user.getEmployees());
			userExists.setId(user.getId());
			userExists.setManager(user.getManager());
			userExists.setRecepno(user.getRecepno());
			userRepository.save(userExists);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteUser(Long id) {
		Optional<User> existingUserOptional = userRepository.findById(id);
		if(existingUserOptional.isPresent())
		{
			userRepository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
