package com.factchecker.factChecker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.factchecker.factChecker.dao.UserRepo;
import com.factchecker.factChecker.entity.User;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.findByUsername(username);

		if (user != null) {
			return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
					.password(user.getPassword()).roles(user.getRole()).build();
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
