package com.factchecker.factChecker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.factchecker.factChecker.dao.UserRepo;
import com.factchecker.factChecker.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepo repo;

	@Autowired
	UserDetailsService service;

	@Autowired
	PasswordEncoder encode = new BCryptPasswordEncoder();

	public ResponseEntity<String> register(User user) {

		User userCheck = repo.findByUsername(user.getUsername());

		if (userCheck == null) {
			User userNew = new User();
			userNew.setAge(user.getAge());
			userNew.setName(user.getName());
			userNew.setRole("User");
			userNew.setUsername(user.getUsername());
			userNew.setPassword(encode.encode(user.getPassword()));

			User isSaved = repo.save(userNew);
			if (isSaved != null) {
				return new ResponseEntity("Registered Successfully..", HttpStatus.OK);
			} else {
				return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
			}

		} else {
			return new ResponseEntity("User With This UserName Already Exists Please Login", HttpStatus.OK);

		}

	}

	public List<User> getAll() {
		List<User> users = repo.findAll();
		List<User> list = new ArrayList<User>();
		for (User user : users) {
			if (!user.getUsername().equals("admin")) {

				list.add(user);
			}
		}
		return list;

	}

	public String deleteUser(String username) {
		User user = repo.findByUsername(username);

		if (user != null) {
			repo.delete(user);
			return "User Deleted Successfully..";
		} else {
			return "Unable To Delete User Successfully..";

		}
	}

	public String updateUser(User user) {
	    User userCheck = repo.findByUsername(user.getUsername());

	    if (userCheck != null) {
	        userCheck.setName(user.getName());
	        userCheck.setAge(user.getAge());

	        // Re-encode the new password only if it's changed
	        userCheck.setPassword(encode.encode(user.getPassword()));

	        repo.save(userCheck);
	        return "User Updated Successfully..";
	    } else {
	        return "Unable To Update User..";
	    }
	}
	public User getByUsername(String username) {
		return repo.findByUsername(username);

	}

}
