/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdistinctcharacters;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *This class contains method to count distinct characters in given input string.
 * It also uses hash map to cache previous calculated result.
 * @author Twinkle Garg
 */
public class CountDistinctCharacters {

    HashMap<String,Integer> wordCache;
    
    /**
     * Constructor initializes the hash map for cache
     */
    public CountDistinctCharacters(){
        wordCache=new HashMap<>();
    }
    
    /**
     * This method counts distinct characters from given input string
     * @param word
     * @return number of distinct characters
     */
    public int countChracters(String word){
        if(wordCache.containsKey(word)){
            return wordCache.get(word);
        }
        ArrayList<Character> arrayOfCharacters=new ArrayList<>();
        for(int count=0;count<word.length();count++){
            if(!arrayOfCharacters.contains(word.charAt(count))){
                arrayOfCharacters.add(word.charAt(count));
            }
        }
        wordCache.put(word,arrayOfCharacters.size());
        return arrayOfCharacters.size();
    }
    
}
