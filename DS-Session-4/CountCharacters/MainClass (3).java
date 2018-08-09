
package countdistinctcharacters;

import java.util.Scanner;

/**
 *Main working class for count distinct characters
 * @author Twinkle-Garg
 */
public class MainClass {
    
    public static void main(String args[]){
        CountDistinctCharacters countCharacters=new CountDistinctCharacters();
        while(true){
            System.out.println("Enter word..!!");
            Scanner input=new Scanner(System.in);
            String inputString=input.next();
            System.out.println(""+countCharacters.countChracters(inputString));
        }
    }
}
