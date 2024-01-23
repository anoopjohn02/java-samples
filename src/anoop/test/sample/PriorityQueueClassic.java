package anoop.test.sample;

import java.util.PriorityQueue;

public class PriorityQueueClassic {
    public static void main(String[] args) {
        //System.out.println("Result 19:34 = " + nextClosestTime("19:34"));
        //System.out.println("Result 13:55 = " + nextClosestTime("13:55"));
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (p1, p2) -> (p2[0] * p2[0]) + (p2[1] * p2[1]) - (p1[0] * p1[0]) - (p1[1] * p1[1]));
        return null;
    }
}
