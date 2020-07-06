package com.example.toyproject.handler;

import java.io.IOException;

import javax.security.auth.login.CredentialExpiredException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.example.toyproject.security.CustomUsersService;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	@Autowired
	CustomUsersService CUS;
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String errorMessage = null;
		
		if(exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "���̵� ��й�ȣ�� ���� �ʽ��ϴ�. bad ID or Password";
		}
		else if (exception instanceof DisabledException) {
			
			errorMessage = "������ ��Ȱ��ȭ �Ǿ����ϴ�. account is disabled";
		}
//		else if (exception instanceof CredentialExpiredException) {
//			errorMessage = "��й�ȣ ��ȿ�Ⱓ ����. Password expiration"; 	
//		}
			
		
	}
	
	public void loginFailuerCount(String username) {
		
	}

	
}
