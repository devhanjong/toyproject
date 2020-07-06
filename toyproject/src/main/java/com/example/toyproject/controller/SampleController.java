package com.example.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@Log
public class SampleController {
	
	@GetMapping("/home1")
	public String home1() {
		return "index";
	}
	
	
	@GetMapping("/")
	public String index() {
		log.info("index");
		return "index";
	}
	

	@PostMapping("/")
	public String indexPost() {
		log.info("indexPost");
		return "index";
	}

	@RequestMapping("/guest") 
	public void forGuest() {
		log.info("guest");
	}
	
	@RequestMapping("/manager")
	public void forManager() {
		log.info("manager");
	}

	@RequestMapping("/admin")
	public void forAdmin() {
		log.info("admin");
	}

}
