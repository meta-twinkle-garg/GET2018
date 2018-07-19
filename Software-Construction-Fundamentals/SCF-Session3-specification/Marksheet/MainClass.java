package Marksheet;

import java.util.Scanner;

public class MainClass {
	public static void main(String args[]){ 
	System.out.println("Enter number of students");
	Scanner input=new Scanner(System.in);
	int numOfStudents=input.nextInt();

	Marksheet markSheet=new Marksheet(numOfStudents);
	markSheet.initialize();
	int maximum=markSheet.maximumGrade();
	System.out.println("Maximum grade is: "+maximum);
	int minimum=markSheet.minimumGrade();
	System.out.println("Minimum grade is: "+minimum);
	double averageGrade=markSheet.average();
	System.out.println("Average grade is : "+averageGrade);
	double percentPassed=markSheet.findPercentPassed();
	System.out.println("Percentage of students passed is : "+percentPassed);
	input.close();
}
}
