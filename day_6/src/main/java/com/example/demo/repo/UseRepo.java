package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Use;

public interface UseRepo extends JpaRepository<Use, Integer> {

}
