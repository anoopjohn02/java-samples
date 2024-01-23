package anoop.test.sample;

import java.util.Arrays;

public class NextTime {
    public static void main(String[] args) {
        //System.out.println("Result 19:34 = " + nextClosestTime("19:34"));
        //System.out.println("Result 13:55 = " + nextClosestTime("13:55"));
        System.out.println("Result 23:59 = " + nextClosestTime("23:59"));
    }

    public static String nextClosestTime(String time) {

        char[] digits = new char[]{time.charAt(0),time.charAt(1),time.charAt(3),time.charAt(4)};
        Arrays.sort(digits);

        StringBuilder result = new StringBuilder(time);
        for(int i=time.length()-1; i>=0; i--){
            if(time.charAt(i) == ':'){
                continue;
            }
            char ch = '\0';
            if(i == 3){
                ch = findNext(digits, time.charAt(i), '5');
            } else if(i == 0){
                ch = findNext(digits, time.charAt(i), '2');
            } else {
                if(time.charAt(0) == '2')
                    ch = findNext(digits, time.charAt(i), '3');
                else
                    ch = findNext(digits, time.charAt(i), (char)('9' + 1));
            }
            result.setCharAt(i, ch);
            if(ch > time.charAt(i)){
                return result.toString();
            }
            System.out.println(result.toString());
        }
        return result.toString();
    }

    private static char findNext(char[] digits, char c, char u){
        System.out.println("c = "+c+",u = "+u);
        int cIdx = Arrays.binarySearch(digits, c);
        while(cIdx < digits.length){
            System.out.println("    cIdx = "+cIdx+", "+digits[cIdx]);
            if(digits[cIdx] <= u && digits[cIdx] > c){
                return digits[cIdx];
            }
            cIdx++;
        }
        return cIdx == digits.length ? digits[0] : digits[cIdx];
    }
}
