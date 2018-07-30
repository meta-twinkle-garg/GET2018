
public class Flamingo extends Bird {

    static int count;
    public Flamingo(String name,int age){
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
        return "Flamingo";
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


