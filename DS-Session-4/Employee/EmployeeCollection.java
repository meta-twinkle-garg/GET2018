import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class contains collection of employee and perform certain operation:
 * 1. add employee to collection
 * 2. sort by natural order
 * 3. sort by names
 * 4. display list of employee
 * @author Twinkle Garg
 *
 */
public class EmployeeCollection {

     List<Employee> listOfEmployee;
   
     /**
      * Constructor initializes arraylist of employee
      */
     public EmployeeCollection(){
         listOfEmployee=new ArrayList<>();
     }
    
     /**
      * This method adds an employee to collection if it does not already exists
      * @param employee
      */
    public void addEmployee(Employee employee){
        for(int count=0;count<listOfEmployee.size();count++){
            if(listOfEmployee.get(count).isEquals(employee)){
                throw new AssertionError("Employee already exists.!!");
            }
        }
        listOfEmployee.add(employee);
    }
    
    /**
     * This method uses comparable to sort employee by id
     * @return
     */
    public List<Employee> sortByNaturalOrder(){
        Collections.sort(listOfEmployee);
        displayList();
        return listOfEmployee;
    }
    
    /**
     * This method displays list of employee
     */
    public void displayList(){
        for(int count=0;count<listOfEmployee.size();count++){
            System.out.println(listOfEmployee.get(count).getDetails());
        }
    }

    /**
     * This method uses comparator to sort employee by name
     * @return
     */
    public List<Employee> sortByName(){
        Collections.sort(listOfEmployee,Employee.NameComparator);
        displayList();
        return listOfEmployee;
    }
    public static void main(String args[]){
        Employee employee1=new Employee(1,"twinkle","Jaipur");
        Employee employee2=new Employee(2,"abcd","J&K");
        EmployeeCollection collection=new EmployeeCollection();
        collection.addEmployee(employee1);
        collection.addEmployee(employee2);
        System.out.println("By natural order..!!");
        collection.sortByNaturalOrder();
        System.out.println("By name..!!");
        collection.sortByName();
    }

}
