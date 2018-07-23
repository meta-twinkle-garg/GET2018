package ArrOperation;
/***
 * Class ArrOperation contains certain functions to be implemented on 1-D array:
 * 1. To fix X-Y problem
 * 2. To find number of clumps
 * 3. To split array in 2 parts such that sum of elements of both parts are equal
 * 4. To find largest size of mirror
 * @author Twinkle-Garg
 */
public class ArrOperation {
	int sizeOfArray;
/***
 * This constructor will initialize size of array
 * @param size 
 */
	public ArrOperation(int size) {
            if(size==0){
			throw new AssertionError("length=0");
		}
            sizeOfArray = size;
                
	}
/***
 * Return an array that contains exactly the same numbers as the input array, 
 * but rearranged so that every X is immediately followed by a Y.
 * @param FixXyArray, input array
 * @param x
 * @param y
 * @return rearranged array
 */
	public int[] rearrange(int[] FixXyArray, int x, int y) {
		int[] otherElements = new int[sizeOfArray];
		int[] requiredArray = new int[sizeOfArray];
		int index = 0, index2 = 0, numberOfX =0, numberOfY=0;
		for (int counter = 0; counter < sizeOfArray; counter++) {
			if (!(FixXyArray[counter] == x || FixXyArray[counter] == y)) {
				otherElements[index++] = FixXyArray[counter];
			}
                        if (FixXyArray[counter] == x){
                            numberOfX++;
                        }
                        if(counter<sizeOfArray-1&&FixXyArray[counter] == x&&FixXyArray[counter+1] == x){
                            throw new AssertionError("occurence detected of consecutive x's..!!");
                        }
                        if (FixXyArray[counter] == y){
                            numberOfY++;
                        }
		}
                if(numberOfX!=numberOfY){
                    throw new AssertionError("Unequal number of x and y..!!");
                }
                if(FixXyArray[sizeOfArray-1]==x){
                   throw new AssertionError("x at last position..!!"); 
                }
		for (int count = 0; count < sizeOfArray; count++) {
			if (FixXyArray[count] == x) {
				requiredArray[count] = x;
				requiredArray[++count] = y;
			} else {
				requiredArray[count] = otherElements[index2++];
			}
		}

		return requiredArray;
	}
/***
 * Return the number of clumps in the input array
 * @param arrayToSearch
 * @return number of clumps
 */
	public int findClumps(int[] arrayToSearch) {
		int numOfClumps = 0;
		for (int counter = 0; counter < sizeOfArray - 1; counter++) {
			if (counter == 0) {
				if (arrayToSearch[counter] == arrayToSearch[counter + 1]) {
					numOfClumps++;
				}
			} else {
				if ((arrayToSearch[counter] == arrayToSearch[counter + 1])
						&& (arrayToSearch[counter] == arrayToSearch[counter - 1])) {
					continue;
				} else if ((arrayToSearch[counter] == arrayToSearch[counter + 1])
						&& (arrayToSearch[counter] != arrayToSearch[counter - 1])) {
					numOfClumps++;
				} else {
					continue;
				}
			}
		}
		return numOfClumps;
	}
/***
 * Return the index if there is a place to split the input array so that,
 * the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1.
 * @param arrayToSplit
 * @return index
 */
	public int splitArray(int[] arrayToSplit) {
		int sumOfArray=0,sumOfOther=0;
                
		for(int counter=0;counter<sizeOfArray;counter++){
			sumOfArray+=arrayToSplit[counter];
		}
		if(sumOfArray%2!=0){
			return -1;
		}else{
			for(int count=sizeOfArray-1;count>-1;count--){
				sumOfOther+=arrayToSplit[count];
				sumOfArray-=arrayToSplit[count];
				if(sumOfOther==sumOfArray){
					return count;	
				}
			}
			return -1;
		}
	}
/***
 * Return the size of the largest mirror section found in the input array
 * @param arrayToSearch
 * @return size of mirror
 */
	public int findLargestMirror(int[] arrayToSearch){
		int count, length;

		int maxLength=1,lengthMirror;
		boolean foundMirror=false;
		for(count=0;count<sizeOfArray;count++){
                        int temp=count;
                        lengthMirror=1;
			for(int count2=sizeOfArray-1;count2>=0&&(temp<sizeOfArray);count2--){
				if(arrayToSearch[temp]==arrayToSearch[count2]&&!foundMirror){
					foundMirror=true;
					temp++;
                                        continue;
				}
                                if(arrayToSearch[temp]==arrayToSearch[count2]&&foundMirror){
					lengthMirror++;
					temp++;
                                    if(maxLength<lengthMirror){
					maxLength=lengthMirror;
                                    }  
                                    continue;
				}
                                if((arrayToSearch[count]!=arrayToSearch[count2])&&(foundMirror)){
                                    foundMirror=false;
                                    temp=count;
                                    lengthMirror=1;
                                    continue;
                                }
                                if(1==(count2-temp)||temp==count2){
                                foundMirror=false;
                                break;
                                }

			}
		}
		return maxLength;
	}
}
