import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Poly {
int[][] polynomial;
int size;
public Poly(int[][] inputArray){
    size=inputArray.length;
    polynomial=new int[size][2];
    polynomial=inputArray;
    arrangePolynomial();
    sortPolynomial();
}
public void arrangePolynomial(){
    for(int count=0;count<size;count++){
        for(int count2=count+1;count2<size;count2++){
            if(polynomial[count][0]==polynomial[count2][0]){
                polynomial[count][1]+=polynomial[count2][1];
                remove(count2);
            }
        }
    }
}
public void sortPolynomial(){
    for(int count=0;count<size;count++){
        for(int count2=count+1;count2<size;count2++){
            if(polynomial[count][0]<polynomial[count2][0]){
                int swapVariable=polynomial[count][0];
                polynomial[count][0]=polynomial[count2][0];
                polynomial[count2][0]=swapVariable;
                swapVariable=polynomial[count][1];
                polynomial[count][1]=polynomial[count2][1];
                polynomial[count2][1]=swapVariable;
            }
        }
    }
}
public void remove(int index){
    for(int count=index;count<size-1;count++){
        polynomial[count][0]=polynomial[count+1][0];
        polynomial[count][1]=polynomial[count+1][1];
    }
    size--;
}
public int evaluate(int number){
    int value=0;
    for(int count=0;count<size;count++){
        value+=Math.pow(number, polynomial[count][0])*polynomial[count][1];
    }
    return value;
}
public Poly addPolynomial(Poly p1,Poly p2){
    int[][] array1=p1.getPolynomial();
    int[][] array2=p2.getPolynomial();
    int[][] array=new int[p1.size+p2.size][2];
    int index=0;
    int count=0,count2=0;
    while(count<p1.size && count2<p2.size){
            if(array1[count][0]==array2[count2][0]){
                array[index][0]=array1[count][0];
                array[index][1]=array1[count][1]+array2[count2][1];
                index++;
                count++;
                count2++;
            }else if(array1[count][0]<array2[count2][0]){
                array[index][0]=array2[count2][0];
                array[index][1]=array2[count2][1];
                count2++;
                index++;
            }else{
                array[index][0]=array1[count][0];
                array[index][1]=array1[count][1];
                count++;
                index++;
        }
    }
    while(count<p1.size){
        array[index][0]=array1[count][0];
        array[index][1]=array1[count][1];
        count++;
        index++;
    }
    while(count2<p2.size){
        array[index][0]=array2[count2][0];
        array[index][1]=array2[count2][1];
        count2++;
        index++;
    }
    Poly newObject=new Poly(array);
    newObject.size=index-1;
    return newObject;
}
public void display(){
    System.out.print("Polynomial is: ");
    for(int count=0;count<size;count++){
            System.out.print(""+polynomial[count][1]+"X^"+polynomial[count][0]);
        if(count!=size-1){
            System.out.print("+");
        }
    }
    System.out.println();
}
public int[][] getPolynomial(){
    return polynomial;
}
public int getDegree(){
    return polynomial[0][0];
}
public Poly multiplyPolynomial(Poly p1,Poly p2){
    int[][] array1=p1.getPolynomial();
    int[][] array2=p2.getPolynomial();
    int[][] array=new int[p1.size*p2.size][2];
    int index=0;
    for(int count=0;count<p1.size;count++){
        for(int count2=0;count2<p2.size;count2++){
            array[index][0]=array1[count][0]+array2[count2][0];
            array[index][1]=array1[count][1]*array2[count2][1];
            index++;
        }
    }
    Poly newObject=new Poly(array);
    newObject.size=index-1;
    return newObject;
}
}
