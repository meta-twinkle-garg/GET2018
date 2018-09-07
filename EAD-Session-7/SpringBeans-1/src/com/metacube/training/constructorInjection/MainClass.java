package com.metacube.training.constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainClass {

	public static void main(String args[]){
		ApplicationContext factory = new ClassPathXmlApplicationContext("constructorInjection.xml");
		TextEditor editor= (TextEditor) factory.getBean("textEditor");
		System.out.println(editor.getSpellChecker().getSpellCheck());
	}
}