package anoop.test.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Result ([]) = " + isValid("([])"));
        System.out.println("Result ([ = " + isValid("(["));
        System.out.println("Result ( = " + isValid("("));
        System.out.println("Result ) = " + isValid(")"));
    }
    private static boolean isValid(String s) {

        if(s==null || s.length()==0)
            return false;

        Stack<Character> stack = new Stack();

        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        int count = 0;
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsValue(ch)){
                stack.push(ch);
                count++;
            } else {
                if(count == 0){
                    return false;
                }
                char expCh = map.getOrDefault(ch, '\0');
                char popVal = stack.pop();
                count--;
                if(expCh != popVal){
                    return false;
                }
            }
        }
        return count == 0;
    }
}
