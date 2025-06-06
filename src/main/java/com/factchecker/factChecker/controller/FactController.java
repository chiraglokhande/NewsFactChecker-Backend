package com.factchecker.factChecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.factchecker.factChecker.entity.Claims;

@RestController
@RequestMapping("factcheck")
public class FactController {

	
	
	@Autowired
	RestTemplate rest;
	
	
	@GetMapping
	public Claims factCheck()
	{
		return rest.exchange("https://factchecktools.googleapis.com/v1alpha1/claims:search?query=does india won wc&key=AIzaSyD18SiCDdUbRShaJsC_r2uwASdfAmQkQ-g",HttpMethod.GET, null,Claims.class).getBody();
	}
	
}
