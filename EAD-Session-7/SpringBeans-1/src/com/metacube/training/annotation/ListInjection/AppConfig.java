package com.metacube.training.annotation.ListInjection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {

	@Bean
	public SumOfNumbers sumOfNumbers() {
		SumOfNumbers sumOfNumbers = new SumOfNumbers();
		List<Integer> myList=new ArrayList<>();
		myList.add(2);
		myList.add(6);
		sumOfNumbers.setMyList(myList);
		return sumOfNumbers;
	}
}
	
