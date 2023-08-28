package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Use;
import com.example.demo.service.UseService;

@RestController
public class UseController {
	@Autowired
	UseService fser;
	
	@GetMapping("getit")
	public List<Use> show(){
		return fser.showinfo();
	}
	
	
 	
	@GetMapping("getId/{id}")
	public Optional<Use> showid(@PathVariable int id) {
		return fser.readid(id);
	}
	
	@GetMapping("getAllUser")
	
		public ResponseEntity<Page<Use>> getAllUSer
		(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortField,
			@RequestParam(defaultValue = "asc") String sortOrder
			
				)
		{
			PageRequest pageRequest = PageRequest.of(page, size,Sort.by(Sort.Direction.fromString(sortOrder), sortField));
			return ResponseEntity.status(200).body(fser.getAllUser(pageRequest));
		}
	
	
	@PostMapping("add")
	public String add(@RequestBody Use fr) {
		return  fser.create(fr);
	}

	
	
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		return fser.deleteId(id);
	}
}
