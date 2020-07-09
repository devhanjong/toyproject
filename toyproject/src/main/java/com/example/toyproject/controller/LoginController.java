package com.example.toyproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.toyproject.Service.UserRegService;
import com.example.toyproject.model.Member;
import com.example.toyproject.repository.MemberRepository;
import com.example.toyproject.repository.MemberRoleRepository;

@Controller
public class LoginController {
	@Autowired
	MemberRoleRepository mrr;

	@Autowired
	HttpSession session;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	private UserRegService reg_service;

	@GetMapping("/login")
	public void login() {

	}

	@PostMapping("/login")
	public String signinPost(@ModelAttribute Member member) {
		Member dbMember = memberRepository.findByUidAndUpw(member.getUid(), member.getUpw());
		if (dbMember != null) {
			session.setAttribute("user_info", dbMember);
		}
		return "redirect:/";
	}

	@GetMapping("/loginResistForm/getid")
	@ResponseBody
	public int getid(@RequestParam("uid") String userid) {
		return reg_service.userIdCheck(userid);
	}

	@GetMapping("/loginResistForm/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("uid") String userid) {
		return reg_service.userIdCheck(userid);
	}

	@PostMapping("/loginResistForm/pwCheck")
	@ResponseBody
	public int pwCheck(@RequestParam("upw") String userpassword1, @RequestParam("upw2") String userpassword2) {

		return reg_service.userPwCheck(userpassword1, userpassword2);
	}

	@GetMapping("/logout")
	public String loout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		session.invalidate();
		return "redirect:/home";
	}

	@PostMapping("/logout")
	public String autoLogout() {
		session.invalidate();

		return "/home";
	}

	@GetMapping("/accessDenied")
	public void accessDenied() {

	}

}
