package com.model;

public class Employee {

	String firstName, lastName, email;
	int age, id;

	public Employee() {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.age = 0;
		id = 0;
	}

	public Employee(String firstName, String lastName, String email, int age,
			int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public void setFirstName(String first) {
		firstName = first;
	}

	public void setLastName(String last) {
		lastName = last;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setId(int id) {
		this.id = id;
	}

}
