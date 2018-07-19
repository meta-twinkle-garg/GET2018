package assignment;
public class StackByArray {
private int[] stack_arr;
private int max;
private static int top;
public StackByArray(int m){
	max=m;
	stack_arr=new int[max];
	top=-1;
}
 public void push(int a){
 if(top==max-1){
	 System.out.println("Stack overflow");
 }else{
	 stack_arr[++top]=a;
	 
 }
 }
 /*public boolean isPallindrome(){
	 int mid=top/2;
	 ques1 new_stack=new ques1(mid);
	 
	 
	 if(top%2==0){
		 
	 }
 }*/
 public void pop(){
	 if(!this.isEmpty()){
		 int val=stack_arr[top--];
		 System.out.println("Popped value is: "+val);
	 }
	 else{
		 System.out.println("Stack underflow");
	 }
 }
 public boolean isEmpty(){
	 if(top==max-1){
	 return true;}
	 else{
		 return false;
	 }
 }
 public static int top(){
	 return top;
 }
 public void display(){
	 System.out.println("The list is: ");
	 for(int i=0;i<=top;i++){
		 System.out.print(" "+stack_arr[i]);
	 }
	 System.out.println();
 }
 
	public static void main(String args[]){
		StackByArray obj=new StackByArray(20);
	obj.push(2);
	obj.push(5);
	obj.push(10);
	obj.display();
	System.out.println("Top index is: "+top());
	obj.pop();
	obj.display();
	
}
}
