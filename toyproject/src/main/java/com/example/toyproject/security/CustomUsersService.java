package com.example.toyproject.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.toyproject.exception.AccountEnabledException;
import com.example.toyproject.model.Member;
import com.example.toyproject.repository.MemberRepository;
import com.example.toyproject.repository.MemberRoleRepository;
import com.example.toyproject.userDetails.CustomUserDetails;

import lombok.extern.java.Log;

@Service
@Log
public class CustomUsersService implements UserDetailsService{
	private static final boolean BadCredentialsException = false;

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberRoleRepository memberRoleRepository;
	
	Member member;
	Member memberrole;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, AuthenticationException {
		
		if(!memberRepository.findById(username).isPresent()) {
			throw new InternalAuthenticationServiceException("아이디 또는 비밀번호가 맞지 않습니다.");
		}
		else {
			this.member = memberRepository.findById(username).get();
			this.memberrole = memberRoleRepository.findById(username).get();
			System.out.println(member);
			
			System.out.println("@@@@@" + memberrole.getRoles() );
			System.out.println(member.getUid());
			
			if(member.getEnable() == 0) {
				//계정비활성화
				throw new AccountEnabledException("계정이 잠겼습니다. 관리자에게 문의하세요");
			}
			
		}
		
		
		
		return new CustomUserDetails(member); 
	}
//		User user = new User(username, member.getUpw(), (Collection<? extends GrantedAuthority>) memberrole.getRoles());
//		Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")
//		System.out.println(user);
//		
//		 CustomSecurityUser user2 = memberRepository.findById(username)
//				.filter(m -> m != null)
//				.map(m -> new CustomSecurityUser(m)) 
//				.get();
	
//		System.out.println(user.getAuthorities());
//		System.out.println(member);
//		System.out.println(member.getRoles());
	
	
//		return user;
		
//		System.out.printf("%s, %s, %s\n", user.getUsername(), user.getPassword(), user.getAuthorities());
//		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
//		System.out.println(bc.encode("pw100"));
		


//		memberRepository.findById(username)
//						.ifPresent(member -> log.info(""+member));
		
				//�븘�씠�뵒 �븘臾닿굅�굹 鍮꾨�踰덊샇 1111 �깦�뵆�쑀�� 濡� MANAGER
//		User sampleUser = new User(username , "{noop}1111", Arrays.asList
//				(new SimpleGrantedAuthority("ROLE_MANAGER")));
//		
//		return sampleUser;
		
}
