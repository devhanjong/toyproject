package com.example.toyproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toyproject.repository.MemberRepository;

@Service
public class UserRegService {
	
	@Autowired
	MemberRepository MR;

	public int userIdCheck(String userid) {
		int result = 1;
		if(MR.findByUid(userid) == null) {
			result = 0;
		}
		
		
		return result;
	}

	public int userPwCheck(String userpassword1, String userpassword2) {
		int result = 1;
		if( userpassword1.equals(userpassword2)) {
			result = 0;
		}
		return result;
	}

}
