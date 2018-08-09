import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class EmployeeTest {

    @Test(expected=AssertionError.class)
    public void testAddEmployee() {
        Employee employee1=new Employee(1,"twinkle","Jaipur");
        Employee employee2=new Employee(2,"abcd","J&K");
        Employee employee3=new Employee(2,"abcd","Jaipur");
        EmployeeCollection collection=new EmployeeCollection();
        collection.addEmployee(employee1);
        collection.addEmployee(employee2);
        collection.addEmployee(employee3);
    }
    
    @Test
    public void testAddEmployeeNaturalSorting() {
        Employee employee1=new Employee(1,"twinkle","Jaipur");
        Employee employee2=new Employee(2,"abcd","J&K");
        EmployeeCollection collection=new EmployeeCollection();
        collection.addEmployee(employee1);
        collection.addEmployee(employee2);
        List<Employee> expectedList=new ArrayList<>();
        expectedList.add(employee1);
        expectedList.add(employee2);
        List<Employee> listOfEmployee=collection.sortByNaturalOrder();
        for(int count=0;count<2;count++){
            String expected=expectedList.get(count).getDetails();
            String result=listOfEmployee.get(count).getDetails();
            assertEquals(expected,result);
        }
    }
        
        @Test
        public void testAddEmployeeSortByName() {
            Employee employee1=new Employee(1,"twinkle","Jaipur");
            Employee employee2=new Employee(2,"abcd","J&K");
            EmployeeCollection collection=new EmployeeCollection();
            collection.addEmployee(employee1);
            collection.addEmployee(employee2);
            List<Employee> expectedList=new ArrayList<>();
            expectedList.add(employee2);
            expectedList.add(employee1);
            List<Employee> listOfEmployee=collection.sortByName();
            for(int count=0;count<2;count++){
                String expected=expectedList.get(count).getDetails();
                String result=listOfEmployee.get(count).getDetails();
                assertEquals(expected,result);
            }

    }

}
