
package search;

import java.util.Scanner;

public class MainClass {
   public static void main(String args[]){
       while(true){
           Scanner input=new Scanner(System.in);
           Search searchInstance=new Search();
           int element;
           System.out.println("1. linear search");
           System.out.println("2. binary search");
           System.out.println("3. exit");
           System.out.println("Enter choice: ");
           int choice=input.nextInt();
           System.out.println("Enter size of array: ");
           int size=input.nextInt();
           int[] arrayToSearch=new int[size];
           switch(choice){
               case 1: System.out.println("Enter array elements: ");
                    for(int count=0;count<size;count++){
                        arrayToSearch[count]=input.nextInt();
                    }
                    System.out.println("Enter element to search: ");
                    element=input.nextInt();

                    int linearIndex=searchInstance.linearSearch(arrayToSearch,arrayToSearch.length-1,0,element);
                    if(linearIndex==-1){
                        System.out.println("Element not found by linear search..!!");
                    }else{
                        System.out.println("Index by linear search is: "+linearIndex);
                    }
                    break;
               case 2: System.out.println("Enter sorted array elements: ");
                    for(int count=0;count<size;count++){
                        arrayToSearch[count]=input.nextInt();
                    }
                    System.out.println("Enter element to search: ");
                    element=input.nextInt();
                    int binaryIndex=searchInstance.binarySearch(arrayToSearch,arrayToSearch.length-1,0,element);
                    if(binaryIndex==-1){
                        System.out.println("Element not found by binary search..!!");
                    }else{
                        System.out.println("Index by binary search is: "+binaryIndex);
                    }
                    break;
               case 3: System.exit(0);
               default: System.out.println("Enter correct choice...!!");
            }
       }
   } 
}
