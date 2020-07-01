package com.example.toyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.toyproject.repository.UserRepository;

@Controller
public class HomeController {
	
	
	@Autowired
	UserRepository ur;
	
	@GetMapping("/signup")
	public String signup() {
		
		return "signup";
	}
	
}
 