package com.factchecker.factChecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.factchecker.factChecker.entity.Claims;

@RestController
@RequestMapping("factcheck")
@CrossOrigin(origins = "https://newsfactchecker.netlify.app/")
public class FactController {

	@Value("${key}")
	private String key;

	@Autowired
	RestTemplate rest;

	@GetMapping("/check")
	public Claims factCheck(@RequestParam String query) {
		return rest
				.exchange("https://factchecktools.googleapis.com/v1alpha1/claims:search?query=" + query + "&key=" + key,
						HttpMethod.GET, null, Claims.class)
				.getBody();
	}

}
