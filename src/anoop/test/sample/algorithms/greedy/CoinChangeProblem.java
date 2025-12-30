package anoop.test.sample.algorithms.greedy;

import java.util.Arrays;

public class CoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = {1,2,5,10,20,50,100,1000};
        int amount = 2035;
        coinChangeProblem(coins, amount);
    }

    private static void coinChangeProblem(int[] coins, int amount) {
        Arrays.sort(coins);
        int lastIndex = coins.length - 1;
        while (amount > 0) {
            int coinValue = coins[lastIndex];
            lastIndex--;
            int maxAmount = (amount/coinValue)*coinValue;
            if(maxAmount > 0) {
                System.out.println("Coin value: " + coinValue +" taken count: "+(amount/coinValue));
                amount = amount - maxAmount;
            }
        }
    }
}
