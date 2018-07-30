import java.util.Arrays;


public class Zoo {
    Cage cageArray[];
    Zone zoneArray[];
    public Zoo(){
        initializeCages();
        initializeZones();
    }
    public void addAnimal(String name, String type, int age){
        Animal object=new Animal();
        Animals animal=Animals.valueOf(type);
        switch(animal){
        case Lion:object=new Lion(name,age);
                   break;
        case Beer:object=new Beer(name,age);
                    break;
        case Flamingo: object=new Flamingo(name,age);
                    break;
        case Penguin: object=new Penguin(name,age);
                    break;
        case Crocodile: object=new Crocodile(name,age);
                    break;
        case Snake: object=new Snake(name,age);
                    break;
        default:System.out.println("enter appropriate animal");
        }

        String category=object.getCategory();
        int zone=findZone(category);
        int cage=findCage(type);
        if(cage==-1){
            System.out.println("No cage available");
            return;
        }
        cageArray[cage].addAnimal(object);

        if(zone==-1){
            System.out.println("No zone available");
            return;
        }
        zoneArray[zone].addCage(cageArray[cage]);
        zoneArray[zone].displayCages();
        
    }
    public void initializeZones(){
        zoneArray=new Zone [4];
        zoneArray[0]=new Zone(5,"Mammal");
        zoneArray[1]=new Zone(3,"Reptile");
        zoneArray[2]=new Zone(6,"Bird");
        zoneArray[3]=new Zone(3,"Mammal");
        
    }
    int findZone(String category){
        for(int count=0;count<4;count++){
            if(zoneArray[count].checkZone(category)!=-1&&zoneArray[count].getStatus()){
                return zoneArray[count].checkZone(category);
            }
        }
        return -1;
    }
    int findCage(String type){
        for(int count=0;count<7;count++){
            if(Arrays.asList(cageArray[count].typeOfAnimal).contains(type)&&cageArray[count].getStatus()){
                return cageArray[count].id;
            }
        }
        return -1;
    }
    public void initializeCages(){
      cageArray=new Cage[7];
      cageArray[0]=new Cage(new String[]{"Crocodile","Snake"},4);
      cageArray[1]=new Cage(new String[]{"Lion","Beer"},5);
      cageArray[2]=new Cage(new String[]{"Flamingo"},2);
      cageArray[3]=new Cage(new String[]{"Flamingo","Penguin"},7);
      cageArray[4]=new Cage(new String[]{"Lion"},4);
      cageArray[5]=new Cage(new String[]{"Crocodile"},3);
      cageArray[6]=new Cage(new String[]{"Snake"},2);
    }
}
