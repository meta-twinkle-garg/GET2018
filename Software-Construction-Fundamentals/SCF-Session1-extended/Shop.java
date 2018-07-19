/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Scanner;
/**
 *
 * @author Home
*/

public class Shop {

   private ArrayList<Item> ItemList;
   private Scanner sc = new Scanner(System.in);
   HashMap<Integer, Item> map;
   int amount,discountAmount;

   public Shop() {
       System.out.println("New Shop for Items created.");
       Item[] obj=new Item[10];
 	  obj[0]=new Item("coffee",40,0);
 	    obj[1]=new Item("tea",30,1);
 	    obj[2]=new Item("ice-cream",50,2);
 	    map = new HashMap<>();
 	   for(int i=0;i<3;i++){
 	 	   map.put(i,obj[i]);
 	    }
   }

   public int getSize() {
       return ItemList.size();

   }

   private Item search(int code) {
	   if(map.containsKey(code)){
		   Item found=map.get(code);
               return found;
           }
	   else
       return null;
   }



   public void addItem() {
       int aCode;
       int aQuantity;
   
     Item foundItem;
       System.out.println("Enter Item code:");
       aCode = sc.nextInt();
       foundItem = search(aCode);
       if (foundItem.getQuantity()==0) {
        
           System.out.println("Quantity : ");
           aQuantity = sc.nextInt();
           Item aItem = map.get(aCode);
           aItem.setQuantity(aQuantity);
       } else if (foundItem.getQuantity()!=0) {
           System.out.println("Item exists");
       }

   }

   public void updateQuantity() {
       int  quantity;
       int code;
       Item foundItem;

      

       System.out.println("Enter Item code:");
       code = sc.nextInt();
       foundItem = search(code);
       if (foundItem == null) {
           System.out.println("Item not found");
           return;
       }
       	   foundItem.display();
           System.out.println("Enter new quantity: ");
           quantity = sc.nextInt();
           foundItem.setQuantity(quantity);
           System.out.println("\n Quantity updated\n");
           System.out.println("Present quantity: " + foundItem.getQuantity());
       }

      
       public void checkItems(){
    	   Item foundItem;
    	   System.out.println("code \t name \t rate");
    	   for(int i=0;i<3;i++){
    		   foundItem=map.get(i);
    		   System.out.println(""+foundItem.getCode()+"\t"+foundItem.getName()+"\t"+foundItem.getRate());
    	   }
       }

   public void removeItem(){
	   int code;
       Item foundItem;
       System.out.println("Enter Item code:");
       code = sc.nextInt();
       foundItem = search(code);
       if (foundItem.getQuantity()==0) {
           System.out.println("Item not found");
           return;
       }else{
    	   foundItem.setQuantity(0);
    	   System.out.println("Item removed successfully..!!");
    	   System.out.println("New bill is: ");
    	   displayBill();
    	   return;
       }
   }

   public void displayBill() {

       int sum=0;
       Item foundItem;
       System.out.println("code \t name \t rate \t quantity");
       for(int i=0;i<3;i++){
    	   foundItem=map.get(i);
    	   if(foundItem.getQuantity()>0){
    		   foundItem.display();
    		   sum=sum+(foundItem.getQuantity()*foundItem.getRate());
    	   }
    	   amount=sum;
       }
       amount=amount-discountAmount;
       System.out.println("Total Amount: "+amount);
       System.out.print("Have any promocode(y/n)??");
       Scanner input=new Scanner(System.in);
       char c;
       c = input.next().charAt(0);
       if(c=='y'){
           System.out.println("Enter code");
           String code=input.next();
           Discount checkDiscount=new Discount();
           int discountPercent=checkDiscount.verifyPromo(code);
           discountAmount=discountPercent*amount/100;
           amount=amount-discountAmount;
           System.out.println("Total Discount: "+discountAmount);
           System.out.println("Total Amount: "+amount);
       }
   
   }



   public double checkPrice(int code) {
       Item foundItem = search(code);
       if (foundItem == null) {
           System.out.println("Item not found");
           return 0.0;
       }

       else
           return foundItem.getRate();
   }
}
