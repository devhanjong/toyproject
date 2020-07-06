package com.example.toyproject.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.example.toyproject.model.Member;
import com.example.toyproject.repository.MemberRepository;

import lombok.Data;

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
		// TODO Auto-generated method stub
		String uid = req.getParameter("username");
		String upw = req.getParameter("password");
		
		loginidname = uid;
		loginpwdname = upw;
		
		loginFailuerCount(uid);
		
		req.setAttribute(loginidname, uid);
		req.setAttribute(loginpwdname, upw);
		
		
//		if (exception instanceof BadCredentialsException
//				|| exception instanceof InternalAuthenticationServiceException) {
//			errorMessage = "bad ID or Password";
//		} else if (exception instanceof DisabledException) {
//
//			errorMessage = "account is disabled";
//		}

	}

	public void loginFailuerCount(String username) {
		 Member mem = member.findById(username).get();
		 int failcount = mem.getFailcount();
		 failcount++;
		 mem.setFailcount(failcount);
		 if(failcount == 3) {
			 mem.setEnable(0);
		 }
			 
	}

}
