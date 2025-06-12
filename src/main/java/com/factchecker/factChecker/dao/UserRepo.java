package com.factchecker.factChecker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factchecker.factChecker.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
	
	
	

}
