package com.harii.Project.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.harii.Project.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	boolean existsByEmail(String Email);
	Optional<User> findById(Long id);
	void deleteById(Long id);
}
