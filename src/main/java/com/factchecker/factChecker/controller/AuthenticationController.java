package com.factchecker.factChecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factchecker.factChecker.dto.Response;
import com.factchecker.factChecker.dto.UserDTO;
import com.factchecker.factChecker.entity.User;
import com.factchecker.factChecker.service.UserDetailsService;
import com.factchecker.factChecker.service.UserService;
import com.factchecker.factChecker.util.JwtUtil;

@RestController
@RequestMapping("authenticate")
@CrossOrigin(origins = "https://gregarious-banoffee-228c22.netlify.app/") 
public class AuthenticationController {

	@Autowired
	UserDetailsService service;

	@Autowired
	JwtUtil util;

	@Autowired
	AuthenticationManager auth;

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody UserDTO dto) {

		try {
			auth.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
			UserDetails user = service.loadUserByUsername(dto.getUsername());
			String JwtToken = util.generateToken(user.getUsername());

			return ResponseEntity.ok(new Response(JwtToken,user.getAuthorities().iterator().next().getAuthority()));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(null);
		}

	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		return userService.register(user);

	}

}
