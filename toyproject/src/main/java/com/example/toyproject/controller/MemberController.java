package com.example.toyproject.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.openqa.selenium.remote.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
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

	@RequestMapping("/alert/infoModificationResult")
	public void infoModificationResult() {
		
	}
	
	
	@RequestMapping("/memberInfoModification")
	public void memberInfoModification() {
//		Enumeration<String> en = session.getAttributeNames();
//		while(en.hasMoreElements()) {
//			String sName = en.nextElement();
//			System.out.printf("[%s] / %s\n", sName, session.getAttribute(sName));
//		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		System.out.println(auth.getPrincipal());
		
		session.setAttribute("userid", auth.getName());
//		HttpResponse HR = new HttpResponse();
//		HR.setAttribute("userid", auth.getName());
		
		
	}
	
	
	@Transactional
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


	
/*
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPost(
			@ModelAttribute Member member,
			Model model) {

		// 중복 아이디 가입 불가를 위해서 가입여부 확인 
		Member findmember = memberRepository.findById(member.getMemberID());
		System.out.println("@@@@@ " + findmember);

		// 2번 입력된 파라미터 활용 
		if (findmember == null) {
			memberRepository.save(member);
		} else {
			model.addAttribute("email", member.getEmail());
			model.addAttribute("name", member.getName());
			return "signup_error2";
		}
		
		
		
		return "redirect:/";
		
		
	}

	@GetMapping("/signout")
	public String signout() {
		session.removeAttribute("member_info"); // 지정된 세션값만 삭제
		session.invalidate(); // 세션의 모든 정보 삭제
		return "redirect:/";
	}
	
	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}

	@PostMapping("/signin")
	public String signinPost(@ModelAttribute Member member) {
		Member dbMember = memberRepository.findByEmailAndPwd(member.getEmail(), member.getPwd());
		if (dbMember != null) {
			session.setAttribute("member_info", dbMember);
		}
		return "redirect:/";
	}

	
	*/
	
	
//	1번 history.back() 활용 
//	if (findUser == null) {
//		userRepository.save(user);
//	} else {
//		return "signDuplicationID";
//	}
	

}
