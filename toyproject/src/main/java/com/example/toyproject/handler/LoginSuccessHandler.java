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

import com.example.toyproject.repository.MemberRepository;

public class LoginSuccessHandler implements AuthenticationSuccessHandler { 
@Autowired
MemberRepository MR;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
			Authentication authentication) throws IOException, ServletException {
		clearAuthenticationAttributes(req);
		MR.findById(req.getParameter("username")).get().setFailcount(0);
		
		
		Collection<? extends GrantedAuthority> list = authentication.getAuthorities();
		Iterator<? extends GrantedAuthority> authlist = list.iterator();
		String url ="/home";
		
		
		while(authlist.hasNext()) {
			GrantedAuthority authority = authlist.next();
			if(authority.getAuthority().equals("ROLE_ADMIN")) {
				url="/admin";
			}
	}
		req.getSession().setAttribute("msg", "관리자페이지");
		res.sendRedirect(url);
		
	}



		    


	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return;
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}


