package com.factchecker.factChecker.service;

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
}
