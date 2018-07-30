import java.util.ArrayList;


public class Zone {
int noOfCages;
String category;
int id;
int spareCapacity;
ArrayList <Cage> cageList;
boolean status=true;
static int count;
    public Zone( int numOfCages, String category){
        this.category=category;
        noOfCages=numOfCages;
        id=count++;
        cageList=new ArrayList<Cage>(noOfCages);
        spareCapacity=numOfCages;
    }
    public int checkZone(String category){
        if(!category.equals(this.category)){
        } else {
            return id;
    }
        return -1;
    }
    public void addCage(Cage cage){
        if(spareCapacity!=0){
            cageList.add(cage);
            spareCapacity--;
        }else{
            status=false;
        }
    }
    public void displayCages(){
        for(int count=0;count<cageList.size();count++){
            System.out.println("cage "+cageList.get(count).getId()+" in Zone "+id);
            cageList.get(count).displayAnimals();
        }
    }
    public boolean getStatus(){
        if(spareCapacity==0){
            status=false;
        }
        return status;
    }
}
