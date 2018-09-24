package com.metacube.training.EmployeeJDBC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
		auth.inMemoryAuthentication().withUser("twinkle").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("Hii");
		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
			.and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/dashboard")
			.loginProcessingUrl("/login")
			.failureUrl("/invalid")
			.and().logout()
			.logoutSuccessUrl("/login")
			.logoutUrl("/logout");
        
	}
}