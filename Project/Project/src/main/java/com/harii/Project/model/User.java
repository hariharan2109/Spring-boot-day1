package com.harii.Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String manager;
	private int employees;
	private String email;
	private String chefname;
	private int recepno;
	
	public User(int id, String manager, int employees, String email, String chefname, int recepno) {
		super();
		this.id = id;
		this.manager = manager;
		this.employees = employees;
		this.email = email;
		this.chefname = chefname;
		this.recepno = recepno;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public int getEmployees() {
		return employees;
	}
	public void setEmployees(int employees) {
		this.employees = employees;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChefname() {
		return chefname;
	}
	public void setChefname(String chefname) {
		this.chefname = chefname;
	}
	public int getRecepno() {
		return recepno;
	}
	public void setRecepno(int recepno) {
		this.recepno = recepno;
	}
}
