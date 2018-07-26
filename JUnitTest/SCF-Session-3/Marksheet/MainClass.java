package Marksheet;

import java.util.Scanner;

public class MainClass {
	public static void main(String args[]){ 
	Marksheet markSheet=new Marksheet(6,new int[]{20,40,60,30,80,10});
	int maximum=markSheet.maximumGrade();
	System.out.println("Maximum grade is: "+maximum);
	int minimum=markSheet.minimumGrade();
	System.out.println("Minimum grade is: "+minimum);
	double averageGrade=markSheet.average();
	System.out.println("Average grade is : "+averageGrade);
	double percentPassed=markSheet.findPercentPassed();
	System.out.println("Percentage of students passed is : "+percentPassed);

}
}
