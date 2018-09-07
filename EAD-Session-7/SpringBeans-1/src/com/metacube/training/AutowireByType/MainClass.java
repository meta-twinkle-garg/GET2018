package com.metacube.training.AutowireByType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainClass {

	public static void main(String args[]){
		ApplicationContext factory = new ClassPathXmlApplicationContext("autowireByType.xml");
		TextEditor editor= (TextEditor) factory.getBean("textEditor");
		System.out.println(editor.callSpellCheck());
	}
}