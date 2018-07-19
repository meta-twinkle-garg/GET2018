package StringFunctions;

import java.util.Scanner;

public class MainClass {
    public static void main(String args[]){
      StringFunctions stringFunction=new StringFunctions();
      String input1,input2,output;
      Scanner input=new Scanner(System.in);
      int choice;
      while(true){
      System.out.println("1. to compare 2 strings\n2. to change case\n3. to reverse\n4. to find maximum length word\n5. to exit");
     System.out.println("Enter appropriate choice");
    
      choice=input.nextInt();
      switch(choice){
      case 1: System.out.println("Enter 2 strings: ");
      		 input1=input.next();
      		 input2=input.next();
      		boolean result=stringFunction.isEqual(input1, input2);
      		if(result){
      			System.out.println("Strings are equal");
      		}else{
      			System.out.println("Strings do not match");
      		}
      		break;
      case 2: System.out.println("Enter the string: ");
      		 input1=input.next();
      		 output=stringFunction.changeCase(input1);
      		System.out.println("After change: "+output);
      		break;
      case 3: System.out.println("Enter the string: ");
		 input1=input.next();
		 output=stringFunction.reverse(input1);
		System.out.println("Reverse String: "+output);
		break;
      case 4: System.out.println("Enter the sentence: ");
		 
		 output=stringFunction.largestWord();
		System.out.println("Largest word: "+output);
		break;
      case 5: System.exit(0);
      default: System.out.println("Enter appropriate choice");
      }}

}
}