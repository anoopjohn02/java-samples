package anoop.test.sample.algorithms.divideconquer;

public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] houseNetWorth = {6,7,1,30,8,2,4};
        System.out.println(houseRobber.maxMoney(houseNetWorth));
    }

    public int maxMoney(int[] houseNetWorth) {
        return maxMoneyRecursive(houseNetWorth, 0);
    }

    private int maxMoneyRecursive(int[] houseNetWorth, int currentIndex) {
        if(currentIndex >= houseNetWorth.length) {
            return 0;
        }

        int stealCurrentHouse = houseNetWorth[currentIndex] + maxMoneyRecursive(houseNetWorth, currentIndex + 2);
        int skipCurrentHouse = maxMoneyRecursive(houseNetWorth, currentIndex + 1);

        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }
}
