package com.metacube.training.MapInjection;


import java.util.Map;

public class SumOfNumbers {

	Map<Integer, Integer> myMap;
	
	public void setMyMap(Map<Integer,Integer> myMap){
		this.myMap=myMap;
	}
	
	public Map<Integer,Integer>  getMyMap(){
		return myMap;
	}
	
	public int getSum(){
		int sum=0;
		Map<Integer,Integer>  listOfInteger=getMyMap();
		for (Map.Entry<Integer,Integer> entry : listOfInteger.entrySet()){
			sum=sum+entry.getValue();
		}
		return sum;
	}
}
