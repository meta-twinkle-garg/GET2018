package AbstractDataTypeIntSet;

public class IntSet implements IntegerSet{
private final int[] array;
private int size;
public IntSet(int[] inputArray){
    this.array=new int[1000];
    for(int element: inputArray){
        if(element>0 && element<1001){
            this.array[element-1]=element;
            size++;
        }else{
            //if(element<0||element>1001)
            System.out.println("Value must lie between 0 to 1000..!!");
        } 
    }
}


public boolean isMember(int x){
    if(x>=0 && x<=1000){
        if(array[x-1]==x){
            return true;
        }else{
            return false;
        }
    }else{
        System.out.println("Value is out of range..!!");
        return false;
    }    
}
public int size(){
    return size;
}
public boolean isSubSet(IntSet s){
    int newSize=s.size();
    if(newSize<=size){
        for(int count=0;count<1000;count++){
            if(s.array[count]==0){
                continue;
            }else{
                if(s.array[count]==this.array[count]){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }else{
        return false;
    }
}
public IntSet complement(){
    IntSet objectInstance;
    int[] complementArray=new int[1000-size];
    int index=0;
    for(int count=0;count<1000;count++){
        if(array[count]==0){
            complementArray[index++]=count+1;  
        }
    }
    objectInstance=new IntSet(complementArray);
    return objectInstance;
}
public IntSet union(IntSet s1,IntSet s2){
    IntSet objectInstance;
    int index=0;
    int unionSize=0;
    for(int count=0;count<1000;count++){
        if(s1.isMember(count+1)||s2.isMember(count+1)){
            unionSize++;
        }
    }
    int[] unionArray=new int[unionSize];
    for(int count=0;count<1000;count++){
        if(s1.isMember(count+1)||s2.isMember(count+1)){
            unionArray[index++]=count+1;
        }else{
            continue;
        }
    }
    objectInstance=new IntSet(unionArray);
    return objectInstance;
}
public void printElements(){
    for(int count=0;count<1000;count++){
        if(array[count]!=0){
            int value=array[count];
            System.out.print(""+value+" ");
        }
    }
}
public int[] getArray(){
    return array;
}

}
