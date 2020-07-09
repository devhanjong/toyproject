package com.example.toyproject.exception;

import org.springframework.security.core.AuthenticationException;

// 비활성 계정
public class AccountNotFoundException extends AuthenticationException {
	
	public AccountNotFoundException(String msg) {
		super(msg);
	}
	 
}
