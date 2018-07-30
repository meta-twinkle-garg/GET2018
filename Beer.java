
public class Beer extends Mammal{
    static int count;
    public Beer(String name,int age){
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
        return "Beer";
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
