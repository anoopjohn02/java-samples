package anoop.test.sample;

import java.util.HashMap;
import java.util.Map;

public class Duplicate {

    public static void main(String[] args) {
        Duplicate duplicate = new Duplicate();
        System.out.println(duplicate.solution(new int[]{5,2,5,5,6,6,10}));
    }
    public int[] solution(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: A) {
            int currentCount = count.getOrDefault(num, 0);
            count.put(num, currentCount + 1);
        }
        int numberOfDuplicates = 0;
        int lowDuplicate = Integer.MAX_VALUE;
        int highDuplicate = Integer.MIN_VALUE;
        for (int key: count.keySet()) {
            if(count.get(key) > 1) {
                numberOfDuplicates++;
                if(key < lowDuplicate) {
                    lowDuplicate = key;
                }
                if(key > highDuplicate) {
                    highDuplicate = key;
                }
            }
        }

        int[] result = new int[count.size() + 3];
        result[0] = numberOfDuplicates;
        result[1] = lowDuplicate;
        result[2] = highDuplicate;
        int index = 3;
        for (int key: count.keySet()) {
            result[index] = key;
            index++;
        }
        return result;
    }
}
