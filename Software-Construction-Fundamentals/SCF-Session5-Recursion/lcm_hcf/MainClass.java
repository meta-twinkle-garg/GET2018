
package lcm_hcf;

import java.util.Scanner;

public class MainClass {
 public static void main(String args[]){
     LcmHcf lcmHcfInstance=new LcmHcf();
     System.out.println("Enter 2 numbers");
     Scanner input=new Scanner(System.in);
     int number1=input.nextInt();
     int number2=input.nextInt();
     System.out.println("HCF is: "+lcmHcfInstance.hcf(number1, number2));
     System.out.println("LCM is: "+lcmHcfInstance.lcm(number1, number2));
 }   
}
