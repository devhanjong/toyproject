package com.example.toyproject.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.toyproject.model.Member;
import com.example.toyproject.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler { 
@Autowired
MemberRepository MR;

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
			Authentication authentication) throws IOException, ServletException {
		log.error("enabled");
		
		clearAuthenticationAttributes(req);
		

		//로그인 성공후 실패카운터 초기화  
		Member mem = MR.findById(req.getParameter("username")).get();
		mem.setFailcount(0);
		MR.save(mem);
		
		Collection<? extends GrantedAuthority> list = authentication.getAuthorities();
		Iterator<? extends GrantedAuthority> authlist = list.iterator();
		String url ="/home";
		
		while(authlist.hasNext()) {
			GrantedAuthority authority = authlist.next();
			if(authority.getAuthority().equals("ROLE_ADMIN")) {
				url="/admin";
			}
	}

		req.setAttribute("user_info", mem);
		res.sendRedirect(url);
		
	}



		    


	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return;
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}


