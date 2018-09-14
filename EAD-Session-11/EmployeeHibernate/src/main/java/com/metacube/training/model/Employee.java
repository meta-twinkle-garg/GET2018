package com.metacube.training.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Override
	public String toString() {
		return "Employee [emp_code=" + id + ", first_name=" + firstName + ", last_name="
				+ lastName + ", email_id=" + emailId + ", skype_id="
				+ skypeId + ", gender=" + gender +", primary_contact_no=" +primaryContactNumber
				+", secondary_contact_no="+secondaryContactNumber+", profile_picture="+profilePicture
				+", password="+password+", dob="+dob+"]";
	}
	
	@Id
	@Column(name = "emp_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "first_name")
	String firstName;
	
	@Column(name = "last_name")
	String lastName;
	
	@Column(name = "gender")
	String gender;
	
	@Column(name = "primary_contact_no")
	String primaryContactNumber;
	
	@Column(name = "secondary_contact_no")
	String secondaryContactNumber;
	
	@Column(name = "email_id")
	String emailId;
	
	@Column(name = "skype_id")
	String skypeId;
	
	@Column(name = "profile_picture")
	String profilePicture;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "dob")
	Date dob;

	public Employee(){
		password="123456";
		profilePicture="default.jpg";
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	public String getSecondaryContactNumber() {
		return secondaryContactNumber;
	}

	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
