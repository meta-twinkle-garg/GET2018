package hexDecimal;

import java.util.Scanner;

public class MainClass {
	public static void main(String args[]){
		HexCalc c=new HexCalc();
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.println("1. to add");
		System.out.println("2. to subtract");
		System.out.println("3. to multiply");
		System.out.println("4. to divide");
		System.out.println("5. to check number1>number2");
		System.out.println("6. to check number1>=number2");
		System.out.println("7. to check number1<number2");
		System.out.println("8. to exit");
		System.out.println("Enter appropriate option");
		int option=sc.nextInt();
		System.out.println("Enter 2 numbers");
		String number1=sc.next();
		String number2=sc.next(); 
		String result;
		boolean compare;
		switch(option){
		case 1:	
			result=c.add(number1, number2);
			System.out.println("addition result = "+result);
			break;
		case 2:
			result=c.diff(number1, number2);
			System.out.println("subtraction result = "+result);
			break;
		case 3:	
			result=c.mult(number1, number2);
			System.out.println("multiplication result = "+result);
			break;
		case 4:	
			result=c.div(number1, number2);
			System.out.println("division result = "+result);
			break;
		case 5:
			compare=c.isGreater(number1,number2);
			System.out.println(""+compare);
			break;
		case 6:
			compare=c.isLess(number1,number2);
			System.out.println(""+compare);
			break;
		case 7:
			compare=c.isEqual(number1,number2);
			System.out.println(""+compare);
			break;
		case 8: System.exit(0);
		default : System.out.println("Enter appropriate option");
		}

	}

	}
}
