package com.metacube.training.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainClass {

	public static void main(String args[]){
		ApplicationContext factory = new ClassPathXmlApplicationContext("prototypeScope.xml");
		Person person= (Person) factory.getBean("Person");
		System.out.println(person.getName());
		person.setName("Garg");
		Person person2= (Person) factory.getBean("Person");
		System.out.println(person2.getName());
	}
}
