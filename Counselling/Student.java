/**
 * 
 * @author Twinkle Garg
 *
 */
public class Student {
	private String name;
	private String[] preferances;

	/**
	 * constructor initializes name and preferences of students
	 * 
	 * @param name
	 *
	 * @param preferances
	 *  
	 */
	public Student(String name, String[] preferances) {
		this.name = name;
		this.preferances = preferances;
	}

	/**
	 * @return name of student
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return order of preferances made by student
	 */
	public String[] getListOfChoices() {
		return preferances;
	}

}