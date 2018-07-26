/***
 * This class contains certain methods for FCFS scheduling. 1. Compute turn
 * around time 2. Compute waiting time 3. Compute completion time 4. Compute
 * average waiting time 5. Compute maximum waiting time
 * 
 * @author Twinkle-Garg
 *
 */
public class JobSchedular {
    int[][] jobArray;
    int numOfJobs;
    int[] complete;
    int[] wait;
    int[] turnAround;

    /***
     * This constructor will initialize job array and call methods to sort jobs
     * and compute completion time, waiting time, and turn around time
     * 
     * @param jobs
     *            -number of jobs
     * @param inputArray
     *            -contains arrival time at index 0 and burst time at index 1
     */
    public JobSchedular(int jobs, int[][] inputArray) {
        numOfJobs = jobs;
        jobArray = new int[jobs][3];
        complete = new int[jobs];
        wait = new int[jobs];
        turnAround = new int[jobs];
        jobArray = inputArray;
        sortJobs();
        completionTime();
        waitingTime();
        turnAroundTime();
    }

    /***
     * This method will swap jobs specified by their indices
     * 
     * @param number1
     *            -index1
     * @param number2
     *            -index2
     */
    public void swap(int number1, int number2) {
        int swapVariable;
        for (int counter = 0; counter < 3; counter++) {
            swapVariable = jobArray[number1][counter];
            jobArray[number1][counter] = jobArray[number2][counter];
            jobArray[number2][counter] = swapVariable;
        }
    }

    /***
     * This method will sort jobs according to their arrival times
     */
    public void sortJobs() {
        for (int count = 0; count < numOfJobs; count++) {
            for (int count2 = count + 1; count2 < numOfJobs; count2++) {
                if (jobArray[count][0] > jobArray[count2][0]) {
                    swap(count, count2);

                }
            }
        }
    }

    /***
     * This method will compute turn around time of all jobs
     * 
     * @return turnAround array containing turn around time
     */
    public int[] turnAroundTime() {
        for (int count = 0; count < numOfJobs; count++) {
            turnAround[count] = complete[count] - jobArray[count][0];
        }
        return turnAround;
    }

    /***
     * This method will compute waiting time of all jobs
     * 
     * @return wait array containing waiting time
     */
    public int[] waitingTime() {
        for (int count = 0; count < numOfJobs; count++) {
            if (count == 0 || jobArray[count][0] > complete[count - 1]) {
                wait[count] = 0;
            } else {
                wait[count] = complete[count - 1] - jobArray[count][0];
            }
        }
        return wait;
    }

    /***
     * This method will compute completion time of all jobs
     * 
     * @return complete array containing completion time
     */
    public int[] completionTime() {
        for (int count = 0; count < numOfJobs; count++) {
            if (count == 0 || jobArray[count][0] > complete[count - 1]) {
                complete[count] = jobArray[count][0] + jobArray[count][1];
                continue;
            } else {
                complete[count] = complete[count - 1] + jobArray[count][1];

            }
        }
        return complete;
    }

    /***
     * this method will compute average waiting time of all jobs
     * 
     * @return average waiting time
     */
    public double getAverageWaitingTime() {
        int sum = 0;
        double average;
        for (int counter = 0; counter < numOfJobs; counter++) {
            sum = sum + wait[counter];
        }
        average = sum / numOfJobs;
        return average;
    }

    /***
     * Computes maximum waiting time
     * 
     * @return maximum waiting time
     */
    public int getMaximumWaiting() {
        int max = wait[0];
        for (int counter = 1; counter < numOfJobs; counter++) {
            if (wait[counter] > max) {
                max = wait[counter];
            }
        }
        return max;
    }
}
