import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Main class
 * 
 * @author Twinkle Garg
 *
 */
public class MainClass {

	public static void main(String[] args) throws RowsExceededException, WriteException, BiffException, IOException {
		Counselling obj = new Counselling();
		obj.readCollegeProgram();
		obj.readStudentData();
		obj.assignProgram();
		obj.writeDataInSheet();
	}

}