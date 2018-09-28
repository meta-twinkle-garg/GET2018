package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.UserRoles;

@Service
public class CustomUserRoleService implements UserDetailsService {


	@Autowired
	EmployeeServiceInterface employeeService;

	@Autowired
	UserRolesServiceInterface  userRolesService;

	@Override
	public UserDetails loadUserByUsername(String emailId)
	throws UsernameNotFoundException {
	Employee user=employeeService.getEmployeeByEmail(emailId);
	if(user==null){
	           throw new UsernameNotFoundException("Username not found"); 
	       }
	           return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), 
	                user.isActive(), true, true, true, getGrantedAuthorities(emailId));
	}

	private List<GrantedAuthority> getGrantedAuthorities(String emailId){
	       List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	       List<UserRoles> listOfUserRoles=userRolesService.getDetailsByEmailId(emailId);
	       for(UserRoles userRoles : listOfUserRoles){
	    	   System.out.println(userRoles.getRole());
	           authorities.add(new SimpleGrantedAuthority("ROLE_"+userRoles.getRole()));
	       }
	       return authorities;
	   }

	}