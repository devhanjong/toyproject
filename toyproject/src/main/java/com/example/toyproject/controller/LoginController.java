package com.example.toyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.toyproject.repository.MemberRoleRepository;

@Controller
public class LoginController {
	@Autowired
	MemberRoleRepository mrr;
	
	@GetMapping("/login")
	public void login() { 
		
	}

	@GetMapping("/logout")
	public void logout() { 
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
		
	}
}
