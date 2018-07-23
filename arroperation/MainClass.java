package ArrOperation;

import java.util.Scanner;



public class MainClass {
public static void main(String args[]) throws AssertionError{
	Scanner input=new Scanner(System.in);
	while(true){
		System.out.println("1. to find number of clumps");
		System.out.println("2. to fix x-y problem");
		System.out.println("3. to find splitting index");
		System.out.println("4. to find maximum length of mirror");
		int choice=input.nextInt();
		System.out.print("Enter size of array: ");
		int size=input.nextInt();
		ArrOperation operationInstance=new ArrOperation(size);
		int [] inputArray=new int[size];
		System.out.println("Enter elements: ");
		for(int counter=0;counter<size;counter++){
			inputArray[counter]=input.nextInt();
		}
		switch(choice){
		case 1: int numOfClumps=operationInstance.findClumps(inputArray);
			System.out.println("Number of clumps: "+numOfClumps);
			break;
		case 2: System.out.print("Enter X and Y: ");
			int X=input.nextInt();
			int Y=input.nextInt();
			int[] result=operationInstance.rearrange(inputArray,X,Y);
			for(int count=0;count<size;count++){
				System.out.print(""+result[count]+" ");
			}
			break;
		case 3: int index=operationInstance.splitArray(inputArray);
			System.out.println("Splitting position: "+index);
			break;
		case 4: int length=operationInstance.findLargestMirror(inputArray);
		System.out.println("Length of largest mirror: "+length);
		break;
		default: System.out.println("Enter correct choice..!!");
		} 
	}
}
}
