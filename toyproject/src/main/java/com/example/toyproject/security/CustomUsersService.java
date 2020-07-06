package com.example.toyproject.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.toyproject.model.Member;
import com.example.toyproject.model.MemberRole;
import com.example.toyproject.repository.MemberRepository;
import com.example.toyproject.repository.MemberRoleRepository;
import com.example.toyproject.userDetails.CustomUserDetails;

import lombok.extern.java.Log;

@Service
@Log
public class CustomUsersService implements UserDetailsService{
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberRoleRepository memberRoleRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findById(username).get();
		Member memberrole = memberRoleRepository.findById(username).get();
		System.out.println("@@@@@" + memberrole.getRoles() );
		String dBuserName = member.getUid(); 
		if(dBuserName == null){
		        throw new UsernameNotFoundException("User not authorized.");
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
		
		return new CustomUserDetails(member); 
	}
		
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
