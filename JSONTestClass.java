import static org.junit.Assert.*;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JSONTestClass {

    @Test
    public void testSum() {
        JSONParser jsonParser = new JSONParser();
        Object object;

        try {

            object = jsonParser.parse(new FileReader("nestedobjects.json"));
            JSONObject jsonObject = (JSONObject) object;
            List<List<Integer>> nestedList=new ArrayList<List<Integer>>();
            for(int count=0;count<5;count++){
                @SuppressWarnings("unchecked")
                List<Integer> list= (List<Integer>)jsonObject.get(String.valueOf(count));
                nestedList.add(list);
            }

            NestedList nestedListObject=new NestedList(nestedList);
            int result=nestedListObject.getSum();
            assertEquals(62,result);
       
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testLargestValue() {
        JSONParser jsonParser = new JSONParser();
        Object object;

        try {

            object = jsonParser.parse(new FileReader("nestedobjects.json"));
            JSONObject jsonObject = (JSONObject) object;
            List<List<Integer>> nestedList=new ArrayList<List<Integer>>();
            for(int count=0;count<5;count++){
                @SuppressWarnings("unchecked")
                List<Integer> list= (List<Integer>)jsonObject.get(String.valueOf(count));
                nestedList.add(list);
            }

            NestedList nestedListObject=new NestedList(nestedList);
            int result=nestedListObject.getLargestValue();
            assertEquals(8,result);
       
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testIsPresent() {
        JSONParser jsonParser = new JSONParser();
        Object object;

        try {

            object = jsonParser.parse(new FileReader("nestedobjects.json"));
            JSONObject jsonObject = (JSONObject) object;
            List<List<Integer>> nestedList=new ArrayList<List<Integer>>();
            for(int count=0;count<5;count++){
                @SuppressWarnings("unchecked")
                List<Integer> list= (List<Integer>)jsonObject.get(String.valueOf(count));
                nestedList.add(list);
            }

            NestedList nestedListObject=new NestedList(nestedList);
            boolean result=nestedListObject.searchValue(8);
            assertEquals(true,result);
       
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


