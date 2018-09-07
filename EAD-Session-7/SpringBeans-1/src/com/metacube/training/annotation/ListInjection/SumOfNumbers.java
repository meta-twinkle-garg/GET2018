package com.metacube.training.annotation.ListInjection;

import java.util.List;

public class SumOfNumbers {

	List<Integer> myList;
	
	public void setMyList(List<Integer> myList){
		this.myList=myList;
	}
	
	public List<Integer> getMyList(){
		return myList;
	}
	
	public int getSum(){
		int sum=0;
		List<Integer> listOfInteger=getMyList();
		for(Integer number:listOfInteger){
			sum=sum+number;
		}
		return sum;
	}
}
