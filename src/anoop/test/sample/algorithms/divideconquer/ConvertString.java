package anoop.test.sample.algorithms.divideconquer;

/**
 * Problem Statement
 * - Two strings S1 and S2
 * - Convert S2 to S1 using delete, insert or replace operations
 * - Find min count of edit operations
 *
 * Example 1
 * - S1 = catch
 * - S2 = carch
 * Output = 1 , Replace r with t
 *
 * Example 2
 * - S1 = table
 * - S2 = tbres
 * Output = 3
 *      insert "a" to second position
 *      replace "r" with "l"
 *      delete "s"
 */
public class ConvertString {
    public static void main(String[] args) {
        ConvertString convertString = new ConvertString();
        System.out.println(convertString.findMinOperations("catch", "carch"));
        System.out.println(convertString.findMinOperations("table", "tbres"));
    }

    private int findMinOperations(String s1, String s2, int firstIndex, int secondIndex) {
        if(firstIndex == s1.length()) {
            return s2.length() - secondIndex;
        }
        if(secondIndex == s2.length()) {
            return s1.length() - firstIndex;
        }
        if(s1.charAt(firstIndex) == s2.charAt(secondIndex)) {
            return findMinOperations(s1, s2, firstIndex+1, secondIndex+1);
        }

        int deleteOp = 1 + findMinOperations(s1, s2, firstIndex+1, secondIndex);
        int insertOp = 1 + findMinOperations(s1, s2, firstIndex, secondIndex+1);
        int replaceOp = 1 + findMinOperations(s1, s2, firstIndex+1, secondIndex+1);

        return Math.min(deleteOp, Math.min(insertOp, replaceOp));
    }

    public int findMinOperations(String s1, String s2) {
        return findMinOperations(s1, s2, 0, 0);
    }
}
