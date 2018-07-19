package AreaOfShapes;

import java.util.Scanner;

public class MainClass {
public static void main(String args[]){
	double result, dimension1,dimension2;
	AreaOfShapes findArea=new AreaOfShapes();
	while(true){
	System.out.println("1. to find area of square");
	System.out.println("2. to find area of rectangle");
	System.out.println("3. to find area of circle");
	System.out.println("4. to find area of trainagle");
	System.out.println("5. to exit");
	System.out.println("Enter your choice: ");
	Scanner input=new Scanner(System.in);
	int option=input.nextInt();
	switch(option){
	case 1: System.out.println("Enter side of square: ");
		dimension1=input.nextDouble();
		result=findArea.areaOfSquare(dimension1);
		System.out.println("Area of square is: "+result);
		break;
	case 2: System.out.println("Enter length and breadth of rectangle: ");
		dimension1=input.nextDouble();
		dimension2=input.nextDouble();
		result=findArea.areaOfRectangle(dimension1,dimension2);
		System.out.println("Area of rectangle is: "+result);
		break;
	case 3: System.out.println("Enter radius of circle: ");
		dimension1=input.nextDouble();
		result=findArea.areaOfCircle(dimension1);
		System.out.println("Area of circle is: "+result);
		break;
	case 4: System.out.println("Enter height and width of triangle: ");
		dimension1=input.nextDouble();
		dimension2=input.nextDouble();
		result=findArea.areaOfTriangle(dimension1,dimension2);
		System.out.println("Area of triangle is: "+result);
		break;
	case 5: System.exit(0);
	default: System.out.println("Enter correct choice");
	}
	}
}
}
