package com.example.toyproject.controller;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {

	@GetMapping("/write")
	public String upload() {
		return "upload2";
	}

	@PostMapping("/write")
	@ResponseBody
	public String uploadPost(@ModelAttribute FileInfo info, @RequestParam("file") MultipartFile mFile) {
		String result = "";
		String oName = mFile.getOriginalFilename();
		result += oName + "\n";	
		return result;
	}

}