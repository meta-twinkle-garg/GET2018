package com.metacube.training.annotation.ListInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class MainClass {
	
	public static void main(String args[]){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		SumOfNumbers sumOfNumbers= (SumOfNumbers) ctx.getBean("sumOfNumbers");
		System.out.println(""+sumOfNumbers.getSum());
	}

}
