package com.metacube.training.SetInjection;

import java.util.Set;



public class SumOfNumbers {

	Set<Integer> mySet;
	
	public void setMyList(Set<Integer> mySet){
		this.mySet=mySet;
	}
	
	public Set<Integer> getMySet(){
		return mySet;
	}
	
	public int getSum(){
		int sum=0;
		Set<Integer> listOfInteger=getMySet();
		for(Integer number:listOfInteger){
			sum=sum+number;
		}
		return sum;
	}
}
