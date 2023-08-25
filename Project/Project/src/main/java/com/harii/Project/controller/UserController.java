package com.harii.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harii.Project.model.User;
import com.harii.Project.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getdetails")
	public ResponseEntity<List<User>> getdetails()
	{
		return ResponseEntity.status(200).body(userService.getUser());
	}
	
	@PostMapping("/adddetails")
	public ResponseEntity<String> addDetails(@RequestBody User user)
	{
		boolean dataSaved = userService.addUser(user);
		if(dataSaved)
		{
			return ResponseEntity.status(200).body("Info added Successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("Something went wrong !");
		}
	}
	
	@PutMapping("/updatedetails/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User user)
	{
		boolean userData = userService.updateUser(id,user);
		if(userData)
		{
			return ResponseEntity.status(200).body("Info Edited Successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("No Record Found to be Edit!");
		}
	}
	
	@DeleteMapping("/deletedetails/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id)
	{
		boolean userDeleted = userService.deleteUser(id);
		if(userDeleted)
		{
			return ResponseEntity.status(200).body("Info Deleted Successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("No Record Found to be Delete!");
		}
	}
}
