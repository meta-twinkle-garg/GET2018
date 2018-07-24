
package search;

/**
 *
 * @author Home
 */
public class Search {
   public int linearSearch(int[] arrayToSearch,int lastIndex,int startIndex, int element){
      if(element==arrayToSearch[startIndex]){
          return startIndex;
      }else if(lastIndex==startIndex){
          return -1;
      } else{
         return linearSearch(arrayToSearch,lastIndex,startIndex+1,element); 
      }
       
   }
   public int binarySearch(int[] arrayToSearch,int lastIndex,int startIndex, int element){
       int mid=(lastIndex+startIndex)/2;
       if(element==arrayToSearch[mid]){
           return mid;
       }else if(startIndex==lastIndex){
           return -1;
       }else if(element>arrayToSearch[mid]){
           return binarySearch(arrayToSearch, lastIndex, mid+1,element);
       }else{
           return binarySearch(arrayToSearch, mid-1, startIndex,element);
       }
   }
}
