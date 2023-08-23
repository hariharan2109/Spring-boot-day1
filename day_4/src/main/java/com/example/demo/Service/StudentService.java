package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.StudentEntity;
import com.example.demo.Repository.StudentRepo;

@Service
public class StudentService {
	@Autowired	
	StudentRepo sr;
	public StudentEntity saveinfo(StudentEntity ss) {
		return sr.save(ss);
	}
	public List<StudentEntity> showinfo(){
		return sr.findAll();
	}
	public StudentEntity changeinfo(StudentEntity ss) {
		return sr.saveAndFlush(ss);
	}
	public void deleteinfo(StudentEntity ss) {
		sr.delete(ss);		
	}
	public Optional<StudentEntity> getbyid(int id){
		return sr.findById(id);
	}
	public String updateinfobyid(int id,StudentEntity ss) {
		sr.saveAndFlush(ss);
		if(sr.existsById(id)) {
			return "Updated";
		}
		else
		{
			return "Enter valid Id";
			
		}
	}

}
