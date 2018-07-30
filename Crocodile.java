
public class Crocodile extends Reptile {

    static int count;
    public Crocodile(String name,int age){
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
        return "Crocodile";
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
