package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_roles")
public class UserRoles {
	@Override
	public String toString() {
		return "UserRoles [id="+id+"role=" + role + ", emailId=" + emailId + "]";
	}
	
	@Id
	@Column(name="id")
	int id;
	
	@Column(name = "role")
	String role;
	
	@Column(name = "email_id")
	String emailId;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
