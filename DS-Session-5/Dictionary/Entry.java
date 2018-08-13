
/**
 * This class is used for entry of dictioanry
 * @author Twinkle Garg
 *
 */
public class Entry {

    String key;
    String value;
    Entry left,right;
   
    /**
     * Constructor initializes instance variables
     * @param key
     * @param value
     */
    public Entry(String key,String value){
        this.key=key;
        this.value=value;
        left=right=null;
    }
    
    /**
     * 
     * @return key
     */
    public String getKey(){
        return key;
    }
    
    /**
     * 
     * @return value
     */
    public String getValue(){
        return value;
    }
}
