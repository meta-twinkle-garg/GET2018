import static org.junit.Assert.*;

import org.junit.Test;

public class JobSchedularTest {

    @Test
    public void testCompletion() {
        int[][] jobArray = { { 0, 10, 0 }, { 6, 20, 1 }, { 60, 10, 2 },
                { 110, 5, 3 } };
        JobSchedular jobTest = new JobSchedular(4, jobArray);
        int[] completion = { 10, 30, 70, 115 };
        assertArrayEquals(completion, jobTest.completionTime());
    }

    @Test
    public void testTurnAround() {
        int[][] jobArray = { { 0, 10, 0 }, { 6, 20, 1 }, { 60, 10, 2 },
                { 110, 5, 3 } };
        JobSchedular jobTest = new JobSchedular(4, jobArray);
        int[] turnAround = { 10, 24, 10, 5 };
        assertArrayEquals(turnAround, jobTest.turnAroundTime());
    }

    @Test
    public void testWaiting() {
        int[][] jobArray = { { 0, 10, 0 }, { 6, 20, 1 }, { 60, 10, 2 },
                { 110, 5, 3 } };
        JobSchedular jobTest = new JobSchedular(4, jobArray);
        int[] waiting = { 0, 4, 0, 0 };
        assertArrayEquals(waiting, jobTest.waitingTime());
    }

    @Test
    public void testMaxWaiting() {
        int[][] jobArray = { { 0, 10, 0 }, { 6, 20, 1 }, { 60, 10, 2 },
                { 110, 5, 3 } };
        JobSchedular jobTest = new JobSchedular(4, jobArray);
        int maxWaiting = 4;
        assertEquals(maxWaiting, jobTest.getMaximumWaiting());
    }

    @Test
    public void testAverageWaiting() {
        int[][] jobArray = { { 0, 10, 0 }, { 6, 20, 1 }, { 60, 10, 2 },
                { 110, 5, 3 } };
        JobSchedular jobTest = new JobSchedular(4, jobArray);
        double averagewait = 1.0;
        assertEquals(averagewait, jobTest.getAverageWaitingTime(), 0.001);
    }

}
