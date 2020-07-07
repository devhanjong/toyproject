package com.example.toyproject.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.example.toyproject.exception.AccountEnabledException;
import com.example.toyproject.exception.AccountNotFoundException;
import com.example.toyproject.model.Member;
import com.example.toyproject.repository.MemberRepository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class LoginFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	MemberRepository member;
	
	private String loginidname;
	private String loginpwdname;
	private String errorMessage;
	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException exception ) throws IOException, ServletException {
		log.error("disabled");
		log.error(exception.getMessage());
		String errorMsg = exception.getMessage();
		
		// TODO Auto-generated method stub
		String uid = req.getParameter("username");
		String upw = req.getParameter("password");
		String url = "/loginResistForm";
		
		if(member.findById(uid).isPresent())loginFailuerCount(uid); 
		if(exception.getMessage().equals("Bad credentials")) {
			errorMsg="아이디 또는 비밀번호가 맞지 않습니다.";
		}
		
		loginidname = uid;
		loginpwdname = upw;
		errorMessage = errorMsg;
		
		req.setAttribute(loginidname, uid);
		req.setAttribute(loginpwdname, upw);
		req.setAttribute("errorMessage", errorMessage); // [[${error
		req.getRequestDispatcher("loginResistForm").forward(req, res);

	}

	public void loginFailuerCount(String username) {
		 Member mem = member.findById(username).get();
		 int failcount = mem.getFailcount();
		 failcount++;
		 mem.setFailcount(failcount);
		 if(failcount >= 3) {
			 mem.setEnable(0);
		 }
		 member.save(mem);
			 
	}

}
