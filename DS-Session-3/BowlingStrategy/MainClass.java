



public class MainClass {

    public static void main(String args[]){
        BowlingStrategy object=new BowlingStrategy(5,3);
        object.addBowler("bowler1", 5);
        object.addBowler("bowler2", 7);
        object.addBowler("bowler3", 4);
        String[] sequence=object.getSequence();
        int i=1;
        for(String bowler:sequence){
            System.out.println(""+i+"\t"+bowler);
            i++;
        }
        
    }
}
