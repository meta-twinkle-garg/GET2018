package com.metacube.training.AutowireByName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainClass {

	public static void main(String args[]){
		ApplicationContext factory = new ClassPathXmlApplicationContext("autowireByName.xml");
		TextEditor editor= (TextEditor) factory.getBean("textEditor");
		System.out.println(editor.callSpellCheck());
	}
}