package anoop.test.sample.algorithms.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(fibDC(6));
        System.out.println(fibMemo(6, new HashMap<>()));
        System.out.println(fibTab(6));
    }

    //Fibonacci Divide and Conquer
    // TIme complexity = O(c^n)
    private static int fibDC(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        return fibDC(n-1) + fibDC(n-2);
    }

    //Fibonacci Memorization - Top down approach
    // TIme complexity = O(n)
    private static int fibMemo(int n, Map<Integer, Integer> memo) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }

        if(!memo.containsKey(n)) {
            int value = fibMemo(n-1, memo) + fibMemo(n-2, memo);
            memo.put(n, value);
        }
        return memo.get(n);
    }

    //Fibonacci Tabulation - Bottom up approach (No recursion)
    // TIme complexity = O(n)
    private static int fibTab(int n) {
        List<Integer> tb = new ArrayList<>();
        tb.add(0);
        tb.add(1);
        for (int i=2; i<n; i++) {
            int value = tb.get(i-1) + tb.get(i-2);
            tb.add(value);
        }
        return tb.get(n-1);
    }
}
