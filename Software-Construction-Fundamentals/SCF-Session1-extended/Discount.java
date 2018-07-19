package ShoppingCart;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Discount {
Date startDate;
Date endDate;
//String code;
//int percent;
public void convertToDate(String s, String e){
	SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	try{
	startDate=ft.parse(s);
	endDate=ft.parse(e);}
	catch(ParseException ex) { 
        System.out.println("Unparseable using " + ft);
}}
public boolean checkValidity(String date){
	SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	try{
   Date strDate = ft.parse(date);

   if(strDate.before(endDate) && strDate.after(startDate)){
	   return true;
   }else{
	   return false;
   
}}
	catch(ParseException ex) { 
        System.out.println("Unparseable using " + ft);
        return false;}
}
public  int verifyPromo(String code){
String start="",end="";
int percent=0;
	
	for (Promocode p : Promocode.values()){
            //System.out.print(p.getCode());
		if(code.equals(p.getCode())){
			 start= p.getStart();
			 end=p.getEnd();
                         percent=p.getPercent();
                      //   System.out.print(p.getStart());
                       //  System.out.print(p.getEnd());
		}
	}
      //  System.out.println(start+"\t"+end);
	if(start==""||end==""){
            System.out.println("Wrong code");
            return 0;
        }
	
	convertToDate(start, end);
	Date currentDate=new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String curDate = dateFormat.format(currentDate); 
                //System.out.println(curDate);
                if(checkValidity(curDate)){
                   
                    System.out.println("Valid");
                    return percent;
                }else{
                    System.out.println("Validity has expired");
                    return 0;
                }
	
	
}
}
