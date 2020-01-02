package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.security.service.MyUserDetailService;

@EnableWebSecurity
public class DemoAuthentication extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailService myUserDetailsService;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		
//		try {
//			auth.inMemoryAuthentication()
//			.withUser("vinod")
//			.password("bharath")
//			.roles("admin")
//			.and()
//			.withUser("bharath")
//			.password("bharath")
//			.roles("user");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		try {
			auth.userDetailsService(myUserDetailsService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Override
//	protected void configure(HttpSecurity http) {
//		try {
//			http.authorizeRequests()
//			.antMatchers("/**").hasAnyRole("user","admin")
//			.and()
//			.formLogin();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
