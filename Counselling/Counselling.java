
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import jxl.Sheet;

import jxl.read.biff.BiffException;
import jxl.Workbook;
import jxl.write.*;

import jxl.write.biff.RowsExceededException;

/**
 * In this program is assigned to a students
 *
 * @author Twinkle Garg
 *
 */
public class Counselling {

    private List<CollegeProgram> listOfCollegeProgram;
    private QueueByLinkedList<Student> listOfStudent;
    private List<AllocatedProgram> listOfAllocatedProgram;

    /**
     * constructor
     */
    public Counselling() {
        listOfCollegeProgram = new ArrayList<CollegeProgram>();
        listOfStudent = new QueueByLinkedList<Student>();
        listOfAllocatedProgram = new ArrayList<AllocatedProgram>();

    }

    /**
     * read programs available from excel sheet
     */
    public void readCollegeProgram() throws IOException {
        String name;
        int noOfSeats;

        try {

            Workbook workbook = Workbook.getWorkbook(new File("ListOfPrograms.xls"));

            Sheet sheetOfPrograms = workbook.getSheet(0);
            int rows = sheetOfPrograms.getRows();

            for (int count = 0; count < rows; count++) {
                name = sheetOfPrograms.getCell(0, count).getContents();
                noOfSeats = Integer.parseInt(sheetOfPrograms.getCell(1, count).getContents());
                listOfCollegeProgram.add(new CollegeProgram(name, noOfSeats));
            }

        } catch (BiffException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * read name of student and their preferences from excel sheet
     */
    public void readStudentData() throws IOException {
        String studentName;
        String[] choices;

        try {

            Workbook workbook = Workbook.getWorkbook(new File("StudentData.xls"));

            Sheet sheetOfStudents = workbook.getSheet(0);
            int rows = sheetOfStudents.getRows();

            for (int count = 0; count < rows; count++) {
                studentName = sheetOfStudents.getCell(0, count).getContents();
                choices = new String[5];
                choices[0] = sheetOfStudents.getCell(1, count).getContents();
                choices[1] = sheetOfStudents.getCell(2, count).getContents();
                choices[2] = sheetOfStudents.getCell(3, count).getContents();
                choices[3] = sheetOfStudents.getCell(4, count).getContents();
                choices[4] = sheetOfStudents.getCell(5, count).getContents();
                listOfStudent.enqueue(new Student(studentName, choices));
            }

        } catch (BiffException e) {

             System.out.println(e.getMessage());

        }

    }

    /**
     * assign particular program to student according to their rank
     */
    public void assignProgram() {
        while (!(listOfStudent.isEmpty())) {
            Student student = listOfStudent.dequeue();
            String preferences[] = student.getListOfChoices();
            String name = student.getName();

            loop:
            for (int count = 0; count < preferences.length; count++) {
                for (int count2 = 0; count2 < listOfCollegeProgram.size(); count2++) {
                    if (listOfCollegeProgram.get(count2).getProgramName().equals(preferences[count])) {
                        if (listOfCollegeProgram.get(count2).getNoOfSeats() > 0) {
                            listOfCollegeProgram.get(count2).setNoOfSeats(listOfCollegeProgram.get(count2).getNoOfSeats() - 1);
                            listOfAllocatedProgram.add(new AllocatedProgram(name, preferences[count]));
                            break loop;
                        }
                    }
                }
            }
        }

        for (int count = 0; count < listOfAllocatedProgram.size(); count++) {
            System.out.println(
                    listOfAllocatedProgram.get(count).getName() + " " + listOfAllocatedProgram.get(count).getProgram());
        }
    }

    /**
     * write program Allocated to student in excel sheet
     *
     * @throws RowsExceededException
     * @throws WriteException
     * @throws BiffException
     */
    public void writeDataInSheet() throws RowsExceededException, WriteException, BiffException {

        try {

            WritableWorkbook workbook = Workbook.createWorkbook(new File("ProgramAllocation.xls"));

            Sheet sheet = workbook.createSheet("firstSheet", 0);
            for (int count = 0; count < listOfAllocatedProgram.size(); count++) {
                Label label1 = new Label(0, count, listOfAllocatedProgram.get(count).getName());
                ((WritableSheet) sheet).addCell(label1);

                Label label2 = new Label(1, count, listOfAllocatedProgram.get(count).getProgram());
                ((WritableSheet) sheet).addCell(label2);
            }
            workbook.write();
            workbook.close();

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}
