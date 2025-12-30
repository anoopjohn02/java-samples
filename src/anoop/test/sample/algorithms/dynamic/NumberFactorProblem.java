package anoop.test.sample.algorithms.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given N, find the number of ways to express N as a sum of 1,3 and 4
public class NumberFactorProblem {

    public static void main(String[] args) {
        System.out.println(waysToGetN(8));
        System.out.println(dynamicTopDown(8, new HashMap<>()));
        System.out.println(dynamicBottomUp(8));
    }

    // Divide and conquer method - Huge time complexity O(3^n)
    public static int waysToGetN(int n) {
        if ((n==0) || (n==1) || (n==2)) {
            return 1;
        }
        if (n == 3) {
            return 2; //{1,1,1} {3}
        }
        int sub1 = waysToGetN(n-1);
        int sub2 = waysToGetN(n-3);
        int sub3 = waysToGetN(n-4);

        return sub1+sub2+sub3;
    }
    // Time complexity = O(n)
    // High space complexity - Stack is using
    public static int dynamicTopDown(int n, Map<Integer, Integer> mem) {
        if ((n==0) || (n==1) || (n==2)) {
            return 1;
        }
        if (n == 3) {
            return 2; //{1,1,1} {3}
        }
        if(!mem.containsKey(n)) {
            int sub1 = dynamicTopDown(n-1, mem);
            int sub2 = dynamicTopDown(n-3, mem);
            int sub3 = dynamicTopDown(n-4, mem);

            int value = sub1+sub2+sub3;
            mem.put(n, value);
        }
        return mem.get(n);
    }
    // Time complexity = O(n), No stack is using
    public static int dynamicBottomUp(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        for (int i=4; i<n+1; i++){
            int value = list.get(i-1) + list.get(i-3) + list.get(i-4);
            list.add(value);
        }
        return list.get(n);
    }
}
