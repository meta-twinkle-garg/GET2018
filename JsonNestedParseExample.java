import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonNestedParseExample {

    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();
        Object object;

        try {

            object = jsonParser.parse(new FileReader("nestedobjects.json"));
            JSONObject jsonObject = (JSONObject) object;
            ArrayList<ArrayList<Integer>> nestedList=new ArrayList<ArrayList<Integer>>();
            for(int count=0;count<5;count++){
                @SuppressWarnings("unchecked")
                ArrayList<Integer> list= (ArrayList<Integer>)jsonObject.get(String.valueOf(count));
                nestedList.add(list);
            }

            System.out.print(nestedList);
            
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}