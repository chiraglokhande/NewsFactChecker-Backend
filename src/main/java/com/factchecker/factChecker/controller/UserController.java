package com.factchecker.factChecker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.factchecker.factChecker.entity.User;
import com.factchecker.factChecker.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	
	@Autowired
	UserService service;
	
	
	@GetMapping("/getall")
	public List<User> getAll()
	{
		return service.getAll();
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
		
	}
	
	
	@DeleteMapping("/deleteUser")
	public String updateUser(@RequestParam String username)
	{
		return service.deleteUser(username);
		
	}
	
	
	@GetMapping("/getByUsername")
	public User getByUsername(@RequestParam String username)
	{
		return service.getByUsername(username);
	}

}


