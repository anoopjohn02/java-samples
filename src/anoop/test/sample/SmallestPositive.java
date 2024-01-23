package anoop.test.sample;

public class SmallestPositive {

    public static void main(String[] args) {
        SmallestPositive smallestPositive = new SmallestPositive();
        System.out.println(smallestPositive.solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(smallestPositive.solution(new int[]{1, 2, 3}));
        System.out.println(smallestPositive.solution(new int[]{-1, -3}));
    }
    public int solution(int[] A) {
        boolean found = false;
        for (int i = 1;; i++) {
            found = false;
            for (int j = 0; j < A.length; j++) {
                int x = A[j];
                if (x == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
    }
}


