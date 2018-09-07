package com.model;

public class Category {
	
	int id;
	String name;
	public Category(){
		id=0;
		name="";
	}
	public Category(String name){
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
