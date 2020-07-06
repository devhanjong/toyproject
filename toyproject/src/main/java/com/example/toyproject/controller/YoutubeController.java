package com.example.toyproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.toyproject.model.YoutubeVideoInfo;
import com.example.toyproject.repository.YoutubeRepository;

@Controller
public class YoutubeController {
	@Autowired
	YoutubeRepository youtubeRepository;
	
	@GetMapping("/info")
	public String youtubecr(Model model) {
		List<YoutubeVideoInfo> list = youtubeRepository.findAll();
		model.addAttribute("list",list);
		
		
		return "info/info";
		
	}

}
