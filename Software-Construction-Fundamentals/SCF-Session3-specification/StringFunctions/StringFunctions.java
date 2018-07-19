
package StringFunctions;

import java.util.Scanner;

/**
 * Stringfunctions class contains various methods for Strings
 * 1. to compare
 * 2. to reverse
 * 3. to change case
 * 4. to return largest word
 * @author Twinkle-Garg
 *
 */
public class StringFunctions {

/**
 * This method will compare equality of 2 strings    
 * @param String1
 * @param String2
 * @return true if String1=String2 else false
 */
    public boolean isEqual(String String1,String String2){
        if(String1.length()==String2.length()){
            for(int counter=0;counter<String1.length();counter++){
                if(String1.charAt(counter)!=String2.charAt(counter)){
                 
                     System.out.println("false");
                    return false;
                }
            }
            System.out.println("true");
            return true;
        }else{
            System.out.println("false");
            return false;
        }
    }
/**
 * This method will compute reverse of a String.
 * @param input String
 * @return reverse String
 */
    public String reverse(String inputString){
        String reversedString="";
        for(int counter=0;counter<inputString.length();counter++){
            reversedString+=inputString.charAt(inputString.length()-counter-1);
        }
         System.out.println(reversedString);
        return reversedString;
    }
/**
 * This method will change lower case to upper case and vice-versa
 * @param input String
 * @return String with opposite case
 */
    public String changeCase(String inputString){
        int length=inputString.length();
        String changedString="";
        for(int counter=0;counter<length;counter++){
            if(inputString.charAt(counter)>=97&&inputString.charAt(counter)<=122){
                int requiredAscii=(int)(inputString.charAt(counter))-32;
                char required=(char)(requiredAscii);
                changedString+=required;
            }else if(inputString.charAt(counter)>=65&&inputString.charAt(counter)<=90){
                int requiredAscii=(int)(inputString.charAt(counter))+32;
                char required=(char)(requiredAscii);
                changedString+=required;
            }else{
                changedString+=inputString.charAt(counter);
            }
        }
        System.out.println(changedString);
        return changedString;
    }
    
/**
 * This method will take a string from user and compute word of maximum length seperated by whitespace
 * @return word of maximum length
 */
	public String largestWord() {
    	String maximum="";
    	String checkWord="";
    	int maxLength=0;
    	int length=0;
    	Scanner inputWord=new Scanner(System.in);
    	String input1=inputWord.nextLine();
    	for(int counter=0;counter<input1.length();counter++){
    		if(input1.charAt(counter)!=' '){
    			length++;
    			checkWord+=input1.charAt(counter);
    		}else{
    			length=0;
    			checkWord="";
    		}
    		if(length>=maxLength){
    		maxLength=length;
    		maximum=checkWord;
    		}
    	}
   
    	System.out.println("Maximum length is: "+maxLength);
    	return maximum;
	}
    
    
}
