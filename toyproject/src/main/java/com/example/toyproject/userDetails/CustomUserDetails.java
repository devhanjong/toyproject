package com.example.toyproject.userDetails;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.toyproject.model.Member;
import com.example.toyproject.security.CustomSecurityUser;

import lombok.Data;

@Data
public class CustomUserDetails implements UserDetails{
	@Autowired
	CustomSecurityUser CSU;
	
	private static final long serialVersionUID = 1L;
	Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		
		return new CustomSecurityUser(member).getAuthorities();
	}
 
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return member.getUpw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return member.getUid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
//	private String username;  //怨꾩젙�쓽 �씠由�
//	private String password;  // 怨꾩젙�쓽 鍮꾨�踰덊샇
//	private boolean isEnabled;  // 怨꾩젙�쓽 �솢�꽦�솕 �뿬遺�  true : �솢�꽦�솕
//	private boolean isAccountNonExpired; // 留뚮즺�릺�뿀�뒗吏� �솗�씤 true : 留뚮즺�븞�맖
//	private boolean isAccountNonLocked;  // 怨꾩젙�쓽 �옞源� �솗�씤 true :�옞湲곗��븡�쓬
//	private boolean isCredentialsNonExpired; //  鍮꾨�踰덊샇媛� 留뚮즺�릺吏��븡�븯�뒗媛�? true 留뚮즺�븞�맖
//	private Collection<? extends GrantedAuthority> authorities;  // 怨꾩젙�씠 媛�吏�怨좎엳�뒗 沅뚰븳紐⑸줉�쓣 由ы꽩�븳�떎 
	
}
 