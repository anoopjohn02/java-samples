package anoop.test.sample.algorithms.divideconquer;

public class ZeroKnapsackProblem {
    public static void main(String[] args) {
         ZeroKnapsackProblem problem = new ZeroKnapsackProblem();
         int[] profits = {31,26,17,72};
         int[] weights = {3,1,2,5};
         int profit = problem.knapSack(profits, weights, 7);
         System.out.println(profit);
    }

    private int knapSack(int[] profits, int[] weights, int capacity, int currentIndex) {
        if(capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) {
            return 0;
        }
        int profit1 = 0;
        int profit2 = 0;
        if(weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapSack(profits, weights, capacity-weights[currentIndex], currentIndex+1);
            profit2 = knapSack(profits, weights, capacity, currentIndex+1);
        }
        return Math.max(profit1, profit2);
    }
    public int knapSack(int[] profits, int[] weights, int capacity) {
        return knapSack(profits, weights, capacity, 0);
    }
}
