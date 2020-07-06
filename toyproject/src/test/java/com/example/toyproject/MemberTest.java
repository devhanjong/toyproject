package com.example.toyproject;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import com.example.toyproject.model.Member;
import com.example.toyproject.model.MemberRole;
import com.example.toyproject.repository.MemberRepository;

import lombok.extern.java.Log;

@SpringBootTest
@Log
@Commit
public class MemberTest {
	@Autowired
	private MemberRepository mr;
	@Autowired
	PasswordEncoder pe;
	
	@Test
	public void testInsert() {
		for(int i =0 ; i <=100 ; i++) {
			Member member = new Member();
			member.setUid("user" + i);
			String pw = pe.encode("pw" + i);
			member.setUpw(pw);
			member.setUname("사용자" + i);
			member.setUemail("aa"+i+"@Email.com");
			
			
			MemberRole role = new MemberRole();
			if(i<=80) { 
				role.setRolename("BASIC");
			}else if (i <= 90) {
				role.setRolename("MANAGER");
			}else {
				role.setRolename("ADMIN");
			}
			member.setRoles(Arrays.asList(role));
			
			mr.save(member);
			}
	} 
	
	@Test
	public void testRead() {
		Optional<Member> result = mr.findById("user85");
		result.ifPresent(member -> log.info("member" + member));
		
	}
		
	
}