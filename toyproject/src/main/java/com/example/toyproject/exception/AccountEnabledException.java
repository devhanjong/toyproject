package com.example.toyproject.exception;

import org.springframework.security.core.AuthenticationException;
 
// 비활성 계정
public class AccountEnabledException extends AuthenticationException {
	
	public AccountEnabledException(String msg) {
		super(msg);
	}
	 
}
