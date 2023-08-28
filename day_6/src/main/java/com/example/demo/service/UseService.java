package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Use;
import com.example.demo.repo.UseRepo;


@Service
public class UseService {
	@Autowired
	UseRepo f;
	
	public List<Use> showinfo(){
		return f.findAll();
	}
	
	public Optional<Use> readid(int id) {
		return f.findById(id);
	}
	
	public String create(Use bk) {
		if(!f.existsById(bk.getId())) {
			f.save(bk);
			return "CREATED SUCCESSFULLY";			
		}
		else
			return "NOT CREATED";
	}
	
	public Use updateId(int id, Use bk) {
		if(f.existsById(id)) {
			System.out.println("UPDATED SUCCESSFULLY");
			return f.saveAndFlush(bk);
		}
		else {
			System.out.println("Please enter a valid id");
			return bk;
		}
	}
	
	public String deleteId(int id) {
		if(f.existsById(id)) {
			f.deleteById(id);
			return "Deleted successfully";
		}
		else
			return "Enter a valid id to delete";
}
	public Page<Use> getAllUser(PageRequest pageRequest)
	{
		return f.findAll(pageRequest);
	}
}
