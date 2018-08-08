
/**
 * @author Twinkle Garg
 *
 */
public class CollegeProgram {
	private String programName;
	private int noOfSeats;

	/**
	 * constructor initializes name and no of seats of program
	 * 
	 * @param programName
	 *
	 * @param noOfSeats
	 * 
	 */
	public CollegeProgram(String programName, int noOfSeats) {
		this.programName = programName;
		this.noOfSeats = noOfSeats;
	}

	/**
	 * @return program name
	 */
	String getProgramName() {
		return programName;
	}

	/**
	 * @return no of seats of program
	 */
	int getNoOfSeats() {
		return noOfSeats;
	}

	/**
	 * set number of seats of program
	 * 
	 * @param noOfSeats
	 */
	void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

}