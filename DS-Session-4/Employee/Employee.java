import java.util.Comparator;

/**
 * Class Employee contains following attributes: 1. Name 2. Id 3. Address
 * 
 * @author Twinkle-Garg
 *
 */
public class Employee implements Comparable<Employee> {

    int empId;
    String name;
    String address;

    /**
     * Constructor initializes instance variables
     * 
     * @param empId
     * @param name
     * @param address
     */
    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    /**
     * 
     * @return id
     */
    public int getId() {
        return empId;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Checks if 2 employee are same by comparing their id
     * 
     * @param employee
     * @return true if they are same
     */
    public boolean isEquals(Employee employee) {
        if (this.getId() == employee.getId()) {
            return true;
        }
        return false;
    }

    /**
     * This method will perform natural sorting based on employee id
     */
    @Override
    public int compareTo(Employee emp) {

        return (this.empId - emp.empId);
    }

    /**
     * 
     * @return details of employee in form of String
     */
    public String getDetails() {
        return ("name: " + name + "\t id: " + empId + "\t address: " + address);
    }

    /**
     * NameComparator used in sorting based on names
     */
    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };
}
