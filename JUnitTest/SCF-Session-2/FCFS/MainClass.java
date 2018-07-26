import java.util.Scanner;

public class MainClass {

    public static void display(int[] arrayDisplay, int[][] jobArray,
            int numOfJobs) {
        System.out.println("Process id \t Time");
        for (int counter = 0; counter < numOfJobs; counter++) {
            System.out.println("" + jobArray[counter][2] + "\t\t"
                    + arrayDisplay[counter]);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of jobs");
        int numOfJobs = sc.nextInt();
        int[][] jobArray = new int[numOfJobs][3];
        System.out.println("Enter arrival time and burst time");
        for (int count = 0; count < numOfJobs; count++) {
            System.out.println("For process" + count);
            jobArray[count][0] = sc.nextInt();
            jobArray[count][1] = sc.nextInt();
            jobArray[count][2] = count;
        }
        JobSchedular job = new JobSchedular(numOfJobs, jobArray);
        int[] turnAround = job.turnAroundTime();
        System.out.println("Turn around time of processes are: ");
        display(turnAround, jobArray, numOfJobs);
        int[] completion = job.completionTime();
        System.out.println("Completion time of processes are: ");
        display(completion, jobArray, numOfJobs);
        int[] wait = job.waitingTime();
        System.out.println("Waiting time of processes are: ");
        display(wait, jobArray, numOfJobs);
        int maximumWait = job.getMaximumWaiting();
        System.out.println("Maximum waiting time is: " + maximumWait);
        double average = job.getAverageWaitingTime();
        System.out.println("Average waiting time is: " + average);
        sc.close();
    }
}
