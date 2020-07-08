package com.example.toyproject.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.toyproject.handler.LoginFailureHandler;
import com.example.toyproject.handler.LoginSuccessHandler;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	CustomUsersService customUserService;
	
	
	//�씪諛섏쟻�씤 �뒪�봽留� �떆�걧由ы떚猷�
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config....");
		
		http 
		.authorizeRequests().antMatchers("/guest/**").permitAll()
		.and()
		.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER")
		.and()
		.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN") 
		.and()
		.formLogin()
		.loginPage("/loginResistForm")
		.successHandler(authenticationSuccessHandler())
		.failureHandler(authenticationFailureHandler())
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/home")
		.invalidateHttpSession(true);
		
		
		http.userDetailsService(customUserService);
		
		 http.sessionManagement()
		   .maximumSessions(1) 
		   .maxSessionsPreventsLogin(true)
		   .expiredUrl("/loginResistForm");
		   
		 
		
		http
		.exceptionHandling().accessDeniedPage("/accessDenied");
		
		
	} 
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//�떆�걧由ы떚�뿉�꽌 �궗�슜�옄瑜� �씤利앺븯�뒗 諛⑸쾿�씠 �떞湲� 媛앹껜
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		
		LoginSuccessHandler successHandler = new LoginSuccessHandler();
		
		return successHandler;
	}

	

/*
 * FailureHandler bean register
 */
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		LoginFailureHandler failureHandler = new LoginFailureHandler();
		failureHandler.setDefaultFailureUrl("history.back()");
		return failureHandler;
	}
}
	
//	
//}
	
	
//		
//		@Override
////		public boolean matches(CharSequence rawPassword, String encodedPassword) {
////			// TODO Auto-generated method stub
////			return rawPassword.equals(encodedPassword);
////		}
////		
////		@Override
////		public String encode(CharSequence rawPassword) {
////			// TODO Auto-generated method stub
////			return rawPassword.toString();
////		}
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}
	
	
	 /* �뒪�봽留� �떆�걧由ы떚 猷곗쓣 臾댁떆�븯寃� �븯�뒗 Url 洹쒖튃. */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//            .antMatchers("/resources/**")
//            .antMatchers("/css/**")
//            .antMatchers("/vendor/**")
//            .antMatchers("/js/**")
//            .antMatchers("/favicon*/**")
//            .antMatchers("/img/**")
//        ;
//    }
	
	

		
//		return new PasswordEncoder() {
//			
//			
//		};
//			
//			



/*
 * LogoutSuccessHandler bean register
 */
//@Bean
//public LogoutSuccessHandler logoutSuccessHandler() {
//    CustomLogoutSuccessHandler logoutSuccessHandler = new CustomLogoutSuccessHandler();
//    logoutSuccessHandler.setDefaultTargetUrl("/loginPage?logout=logout");
//    return logoutSuccessHandler;
//}

/*
 * AccessDeniedHandler bean register
 */
//@Bean
//public AccessDeniedHandler accessDeniedHandler() {
//    CustomAccessDeniedHandler accessDeniedHandler = new CustomAccessDeniedHandler();
//    accessDeniedHandler.setErrorPage("/error/403");
//    return accessDeniedHandler;
//}

/*
 * AuthenticationEntryPoint bean register
 */
//@Bean
//public AuthenticationEntryPoint authenticationEntryPoint() {
//    return new CustomAuthenticationEntryPoint("/loginPage?error=e");
//}

/*
 * Form Login�떆 嫄몃━�뒗 Filter bean register
 */
//@Bean
//public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
//    JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager());
//    jwtAuthenticationFilter.setFilterProcessesUrl("/login");
//    jwtAuthenticationFilter.setUsernameParameter("username");
//    jwtAuthenticationFilter.setPasswordParameter("password");
//    
//    jwtAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
//    jwtAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
//    
//    jwtAuthenticationFilter.afterPropertiesSet();
//    
//    return jwtAuthenticationFilter;
//}

/*
 * Filter bean register
 */
//@Bean
//public JwtAuthorizationFilter jwtAuthorizationFilter() throws Exception {
//    JwtAuthorizationFilter jwtAuthorizationFilter = new JwtAuthorizationFilter(authenticationManager());
//    return jwtAuthorizationFilter;
//}
//}



//	@Autowired
//	DataSource dataSource;
//	
//	@Autowired
//	MemberRepository memberRepository;
//	
	