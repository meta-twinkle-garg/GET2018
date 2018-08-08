
package virtualcommandprompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class Directory contains following attributes:
 * 1.Name
 * 2. Parent directory
 * 3. Timestamp
 * 4. List of sub folders
 * @author Twinkle Garg
 */
public class Directory {

    String name;
    Directory parent;
    Date timestamp;
    List<Directory> listOfChildren;
    
    /**
     * Constructor initializes directory name and its parent
     * @param parent
     * @param name 
     */
    public Directory(Directory parent,String name){
        this.parent=parent;
        this.name=name;
        listOfChildren=new ArrayList<>();
    }
    
    /**
     * This method add directory to children list
     * @param child 
     */
    public void addFolder(Directory child){
        listOfChildren.add(child);
    }
    
    /**
     * 
     * @return parent
     */
    public Directory getParent(){
        return parent;
    }
    
    /**
     * 
     * @return list of sub folders
     */
    public List<Directory> getSubFolders(){
        return listOfChildren;
    }
    
    /**
     * 
     * @return name of directory
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set timestamp of directory
     * @param timestamp 
     */
    public void setTimestamp(Date timestamp){
        this.timestamp=timestamp;
    }
    
    /**
     * 
     * @return timestamp
     */
    public Date getTimestamp(){
        return timestamp;
    }
}

