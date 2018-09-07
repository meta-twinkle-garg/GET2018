package com.metacube.training.ListInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainClass {
	
	public static void main(String args[]){
		ApplicationContext factory = new ClassPathXmlApplicationContext("listInjection.xml");
		SumOfNumbers sumOfNumbers= (SumOfNumbers) factory.getBean("SumOfNumbers");
		System.out.println(""+sumOfNumbers.getSum());
	}

}
