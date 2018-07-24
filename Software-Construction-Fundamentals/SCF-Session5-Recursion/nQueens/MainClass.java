
package nQueens;

import java.util.Scanner;


public class MainClass {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter N: ");
        int N=input.nextInt();
        NQueens NqueenInstance=new NQueens(N);
        NqueenInstance.solveProblem();
        input.close();
    }
}
