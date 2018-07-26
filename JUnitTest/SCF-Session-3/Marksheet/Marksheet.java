package Marksheet;

import java.util.Scanner;

/**
 * Marksheet class will store grades of students Following operations will be
 * performed: 1. Calculate average of all grades 2. Compute minimum grade 3.
 * Compute maximum grade 4. Compute number of students who passed examination
 * 
 * @author Twinkle-Garg
 *
 */
public class Marksheet {
    int[] grades;
    int numOfStudents;

    /**
     * Constructor will initialize number of students and grades
     * 
     * @param number
     * @param grades matrix     
     */
    public Marksheet(int number, int[] grades) {
        numOfStudents = number;
        this.grades = grades;
    }

    /**
     * It will compute average grade of all.
     * 
     * @return average grade
     */
    public double average() {
        double averageGrade;
        int sumOfMarks = 0;
        for (int counter = 0; counter < numOfStudents; counter++) {
            sumOfMarks += grades[counter];
        }
        averageGrade = Math.round((sumOfMarks / numOfStudents) * 100.0) / 100.0;
        return averageGrade;
    }

    /**
     * It will compute maximum grade
     * 
     * @return maximum grade
     */
    public int maximumGrade() {
        int maxGrade = 0;
        for (int counter = 0; counter < numOfStudents; counter++) {
            if (grades[counter] > maxGrade) {
                maxGrade = grades[counter];
            }
        }
        return maxGrade;
    }

    /**
     * It will compute minimum grade
     * 
     * @return minimum grade
     */
    public int minimumGrade() {
        int minGrade = 100;
        for (int counter = 0; counter < numOfStudents; counter++) {
            if (grades[counter] < minGrade) {
                minGrade = grades[counter];
            }
        }
        return minGrade;
    }

    /**
     * it will compute percentage of students who passed the exam by checking
     * grade>=40
     * 
     * @return percentage of students passed
     */
    public double findPercentPassed() {
        int count = 0;
        for (int counter = 0; counter < numOfStudents; counter++) {
            if (grades[counter] > 40) {
                count++;
            }
        }
        double studentPassed = Math
                .round(((double) count / (double) numOfStudents) * 100.0 * 100.0) / 100.0;
        return studentPassed;
    }
}
