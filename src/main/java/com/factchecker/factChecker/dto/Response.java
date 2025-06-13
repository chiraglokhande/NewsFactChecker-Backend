package com.factchecker.factChecker.dto;

public class Response {
	
	String jwt;
	String role;
	
	
	
	public Response(String jwt, String role) {
		super();
		this.jwt = jwt;
		this.role = role;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
