

/**
 * 
 * @author Twinkle Garg
 *
 */
public class AllocatedProgram {
	private String nameOfStudent;
	private String program;

	/**
	 * constructor initializes name and program of student
	 * 
	 * @param name
	 * 
	 * @param program
	 *
	 */
	public AllocatedProgram(String nameOfStudent, String program) {
		this.nameOfStudent = nameOfStudent;
		this.program = program;
	}

	/**
	 * @return name of student
	 */
	public String getName() {
		return nameOfStudent;
	}

	/**
	 * @param nameOfStudent
	 */
	public void setName(String nameOfStudent) {
		this.nameOfStudent = nameOfStudent;
	}

	/**
	 * @return program name
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program
	 *            is program name
	 */
	public void setProgram(String program) {
		this.program = program;
	}

}