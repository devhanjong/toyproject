package com.example.toyproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.toyproject.model.Member;
import com.example.toyproject.repository.MemberRepository;

import lombok.extern.java.Log; 

@Log
@Controller
public class MemberController {
	
	@Autowired
	PasswordEncoder passwordeEncoder;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/loginResistForm")
	public void signup() {
		
	}

	
	
	@GetMapping("/memberInfoModification")
	public void memberInfoModification(Model model) {
	}
	
	@PostMapping("/memberInfoModification")
	public String memberInfoModification(@ModelAttribute("member") Member member) {
		String userid = (String) session.getAttribute("userid");
		String encryptPw = passwordeEncoder.encode(member.getUpw()); 
		member.setUid(userid);
		member.setUpw(encryptPw);
		member.setEnable(1);
		member.setFailcount(0);
		
		memberRepository.save(member);
		
		// 회원정보가 변경되었으므로 세션의 정보도 수정
		session.setAttribute("userid", member.getUid());
		session.setAttribute("userName", member.getUname());
		session.setAttribute("userEmail", member.getUemail());
		
		return "/alert/infoModificationResult";
	}

	
	
	@PostMapping("/resistResult")
	public String SignupPost(@ModelAttribute("member") Member member) {
		//회원가입시 결과화면 
		log.info("MEMBER: " + member);
		 
		String encryptPw = passwordeEncoder.encode(member.getUpw()); 
		
		member.setUpw(encryptPw);
		member.setEnable(1);
		member.setFailcount(0);
		
		  
		memberRepository.save(member);
		
		return "/member/resistResult";
	}


}
