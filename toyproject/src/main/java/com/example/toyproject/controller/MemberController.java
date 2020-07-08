package com.example.toyproject.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/loginResistForm")
	public void signup() {

	}

	@Transactional
	@PostMapping("/resistResult")
	public String SignupPost(@ModelAttribute("member") Member member) {
		// 회원가입시 결과화면
		log.info("MEMBER: " + member);

		String encryptPw = passwordeEncoder.encode(member.getUpw());

		member.setUpw(encryptPw);
		member.setEnable(1);
		member.setFailcount(0);

		memberRepository.save(member);

		return "/member/resistResult";
	}
}
