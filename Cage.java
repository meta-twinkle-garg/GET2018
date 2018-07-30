import java.util.ArrayList;


public class Cage {
    String[] typeOfAnimal;
    int limit;
    int spareCapacity;
    int id;
    int zoneId;
    ArrayList<Animal> animalAdded;
    static int count;
    boolean status=true;
    public Cage(String[] typeOfAnimal, int limit){
        this.typeOfAnimal=typeOfAnimal;
        this.limit=limit;
        this.spareCapacity=limit;
        animalAdded=new ArrayList<Animal>(limit);
        zoneId=-1;
        id=count++;
    }
    public void addAnimal(Animal animal){
        if(spareCapacity==0){
            status=false;
        }else{
            animalAdded.add(animal);
            spareCapacity--;
            }
    }
    public void displayAnimals(){
        for(int count=0;count<animalAdded.size();count++){
            System.out.println(""+animalAdded.get(count).getName()+" in cage "+id);
        }
    }
    public boolean getStatus(){
        if(spareCapacity==0){
        
            status=false;
        }
        return status;
    }
    public int getId(){
        return id;
    }
}
