package hexDecimal;

public class Conversion {
	char[] hexArray;
	public Conversion(){
		hexArray=new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	}
	public int toInt(String hexaDecimal){
		int numberArray[]=new int[hexaDecimal.length()];
		char c;
		int number=0,base;
		for(int counter=0;counter<hexaDecimal.length();counter++){
			c=hexaDecimal.charAt(hexaDecimal.length()-counter-1);
			if(Character.isDigit(c)){
			numberArray[counter]=Character.getNumericValue(c);
			continue;
		}else{
			for(int check=10;check<16;check++){
				if(hexArray[check]==c){
					numberArray[counter]=check;
					break;
				}
			}
		}
	}
		for(int counter=0;counter<hexaDecimal.length();counter++){
			base=(int) (Math.pow(16,counter));
			number=number+(numberArray[counter]*base);
		}
		return number;
	}
	public String toHex(int Decimalnumber){
		int number=Decimalnumber, remainder;
		String hexNumberReverse="", hexNumber="";
		char c;
		while(number!=0){
			remainder=number%16;
			c=hexArray[remainder];
			hexNumberReverse+=c;
			number=number/16;
			}
		for(int i=0;i<hexNumberReverse.length();i++){
		 hexNumber+=hexNumberReverse.charAt(hexNumberReverse.length()-i-1);
		}
		return hexNumber;
	}
}
