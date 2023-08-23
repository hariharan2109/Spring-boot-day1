package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.StudentEntity;
import com.example.demo.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService sser;
	@PostMapping("studentadd")
	public StudentEntity add(@RequestBody StudentEntity ss) {
		return sser.saveinfo(ss);
	}
	@GetMapping("showstudent")
	public List<StudentEntity> show()
	{
		return sser.showinfo();
	}
	@PutMapping("updatestudent")
	public StudentEntity modify(@RequestBody StudentEntity ss) {
		return sser.changeinfo(ss);
	}
	@DeleteMapping("deletestudent")
	public String del(@RequestBody StudentEntity ss) {
		sser.deleteinfo(ss);
		return "Detail has been Deleted Successfully";
	}
	@GetMapping("get/{id}")
	public Optional<StudentEntity> showid(@PathVariable int id)
	{
		return sser.getbyid(id);
	}
	
	public String modifybyid(@PathVariable int id,@RequestBody StudentEntity ss) {
		return sser.updateinfobyid(id, ss);
	}
}
