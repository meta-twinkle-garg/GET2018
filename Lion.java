
public class Lion extends Mammal{
    static int count;
    public Lion(String name,int age){
        this.name=name;
        this.age=age;
        id="M"+count;
        count++;
    }
    void getInfo()
    {
        
    }
    boolean checkProperty()
    {
       return true; 
    }
    String getType(){
        return "Lion";
    }
    @Override
    public String getCategory(){
        return super.getCategory();
    }
    @Override
    public String getName(){
        return name;
    }
}
