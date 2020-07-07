package com.example.toyproject.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.toyproject.model.Member;
import com.example.toyproject.model.MemberRole;

import lombok.Data;

@Data
public class CustomSecurityUser extends User{
	
	private static final String ROLE_PREFIX = "ROLE_";
	
	private Member member;
	
	public CustomSecurityUser(Member member) {
		super(member.getUid(), 
				member.getUpw(), makeGrantedAuthority(member.getRoles()));
		this.member = member;
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){

		List<GrantedAuthority> list = new ArrayList<>();
		
		roles.forEach(
			role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX +role.getRolename())));
		
		return list;
	}
	
//	public ProjectSecurityUser(String username, String password , Collection<? extends GrantedAuthority> authorities) {
//		
//			super(username , password , authorities);
//	}
	
	

}
