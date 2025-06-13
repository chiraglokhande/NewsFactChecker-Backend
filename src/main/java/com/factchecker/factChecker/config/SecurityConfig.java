package com.factchecker.factChecker.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.factchecker.factChecker.filter.JwtFilter;
import com.factchecker.factChecker.service.UserDetailsService;
import com.factchecker.factChecker.util.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	JwtUtil util;

	@Autowired
	JwtFilter filter;
	
	@Autowired
	UserDetailsService service;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
			    .cors(Customizer.withDefaults())
				.authorizeHttpRequests(req -> req.requestMatchers("factcheck/**").authenticated().requestMatchers("user/**").authenticated().anyRequest().permitAll())
				.csrf(cs -> cs.disable()).addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class).build();
	}
	

	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(service).passwordEncoder(encode());
	}
	
	
	
	@Bean
	public PasswordEncoder encode()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationManager manager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
		
	}

}
