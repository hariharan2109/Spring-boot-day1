package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.ApiService;

@RestController
public class EmployeeController {

	@Autowired
	ApiService sser;
	@PostMapping("addemployee")
	public Employee add(@RequestBody Employee ee) {
		return sser.saveinfo(ee);
	}
	@GetMapping("showdetails")
	public List<Employee>show(){
		return sser.showinfo();
	}
}
