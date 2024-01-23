package anoop.test.sample;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubString {

    public static void main(String[] args) {

        System.out.println("Answer1: " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("Answer2: " + minWindow("A", "B"));
        System.out.println("Answer3: " + minWindow("AB", "B"));
        System.out.println("Answer3: " + minWindow("ab", "A"));
        System.out.println("Answer4: " + minWindow("abc", "ac"));
        System.out.println("Answer4: " + minWindow("qxsncfwvbslazxuoxnedkukropehlwfbwxqycntdfgghecvdqbhcwtukkauwzzzvystcfohmupvastekunmqiidtjxriyqdyiyapohekxblrurbpgphoykjhjarhtwfduhvkpzumahdxagmivtxvgiepjvxetehnmczddurgdwdecrmzklxqubgfzfjslqizvheadvghrlnvcbxpnuhjxpqywzrkrbjokqpolxxflkapnzeatmltdbrackkwlvmwlbmxbjcmvebieilzwyszckzgulcihpgsssrtdvhaaligvvfrwaqyksegdjqmywfsoyotuxtwieefbjwxjpxvhcemnwzntgfjetdatyydecjgofdzudxbfbqsxpfsvmebijcbhcemfnuvtzupcrthujbuyiovvswdbagjdkxkyrftqbktvdcpogloqajlsgquiyfljcxjveengogbulsitexjeixwqpszoxkzzkiuooiweqxydqjywiiaqhyhwrgkosloetktjuponposfxrdhzdyibhesprjjczoyjhhgyxtnmlulextdatnecsyrlhangonsxxywutligguldpqgiemkymdjufycumwtjupfpdowjkjozzwjdivbvymrdlvzzstkmkpenfcyplnqkjzquutrsgiytdxsvsckftquzstqdihnrgfnbbevjovcutupnyburrpsjijmsqclyjzzk", "fxtusxonrfdrhxjamdkwm"));
    }

    public static String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        if(t.equals(s)){
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                int value = map.get(c) + 1;
                map.put(c, value);
            } else {
                map.put(c, 1);
            }
        }

        int required = map.size();

        int left = 0;
        int right = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap();
        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {

            char c = s.charAt(right);
            int count =  windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (map.containsKey(c) && windowCounts.get(c).intValue() < map.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right ++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
