package com.example.toyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.toyproject.repository.MemberRepository;

@Controller
public class HomeController {
	 
	@GetMapping("/home")
	public String home() { 
		
		return "index";
	}
	
	
}
 