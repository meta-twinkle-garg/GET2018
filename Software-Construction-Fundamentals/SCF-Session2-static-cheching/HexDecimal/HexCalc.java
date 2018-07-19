package hexDecimal;



public class HexCalc implements NumberSystem{

public String add(String number1, String number2){
	
	Conversion obj=new Conversion();
	int num1=obj.toInt(number1);
	int num2=obj.toInt(number2);
	int sum= num1+num2;
	String result=obj.toHex(sum);
	return result;
}
public String diff(String number1, String number2){
	Conversion obj=new Conversion();
	int num1=obj.toInt(number1);
	int num2=obj.toInt(number2);
	int difference= num1-num2;
	String result=obj.toHex(difference);
	return result;
}
public String mult(String number1, String number2){
	Conversion obj=new Conversion();
	int num1=obj.toInt(number1);
	int num2=obj.toInt(number2);
	int multiply= num1*num2;
	String result=obj.toHex(multiply);
	return result;
}
public String div(String number1, String number2){
	Conversion obj=new Conversion();
	int num1=obj.toInt(number1);
	int num2=obj.toInt(number2);
	int division= num1/num2;
	String result=obj.toHex(division);
	return result;
}
public boolean isGreater(String number1,String number2){
	int counter;
	if(number1.length()>number2.length()){
		return true;
	}else if(number1.length()<number2.length()){
		return false;
	}else{
		if(isEqual(number1,number2)){
			return false;
		}else{
		for(counter=0;counter<number1.length();counter++){
			if(number1.charAt(counter)<number2.charAt(counter)){
				return false;
			}

		}}
	
			return true;
		}
	}

public boolean isLess(String number1,String number2){
	int counter;
	if(number1.length()<number2.length()){
		return true;
	}else if(number1.length()>number2.length()){
		return false;
	}else{
		if(isEqual(number1,number2)){
			return false;
		}else{
		for(counter=0;counter<number1.length();counter++){
			if(number1.charAt(counter)>number2.charAt(counter)){
				return false;
			}
			}
		}
	
			return true;
	}	}
	
public boolean isEqual(String number1,String number2){
	int counter;
	if(number1.length()==number2.length()){
		for(counter=0;counter<number1.length();counter++){
			if(number1.charAt(counter)!=number2.charAt(counter)){
				return false;
			}
			}
		return true;
		}else{
			return false;
		}
	
			
		}
	}




