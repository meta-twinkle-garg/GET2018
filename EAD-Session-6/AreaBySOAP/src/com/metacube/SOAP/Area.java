package com.metacube.SOAP;

public class Area {

	public double areaOfTriangle(int a, int b, int c){
		double semiPerimeter=(a+b+c)/2;
		double area=Math.sqrt(semiPerimeter*(semiPerimeter-a)*(semiPerimeter-b)*(semiPerimeter-c));
		return area;
	}
}
