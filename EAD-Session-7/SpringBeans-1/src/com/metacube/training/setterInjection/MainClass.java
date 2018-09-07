package com.metacube.training.setterInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MainClass {

	public static void main(String args[]){
		ApplicationContext factory = new ClassPathXmlApplicationContext("setterInjection.xml");
		TextEditor editor= (TextEditor) factory.getBean("textEditor");
		System.out.println(editor.getSpellChecker().getSpellCheck());
	}
}
