package com.example.toyproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.toyproject.model.Member;
import com.example.toyproject.repository.MemberRepository;

@Controller
public class MemberController {
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	HttpSession session;
	
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