package com.metacube.training.annotaion.TextEditor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;



public class MainClass {

	public static void main(String args[]){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		TextEditor editor= (TextEditor) ctx.getBean("textEditor");
		System.out.println(editor.getSpellChecker().getSpellCheck());
	}
}
