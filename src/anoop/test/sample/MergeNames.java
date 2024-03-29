package anoop.test.sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> uniqueStrings = new HashSet<>();
        Arrays.stream(names1).forEach(s -> uniqueStrings.add(s));
        Arrays.stream(names2).forEach(s -> uniqueStrings.add(s));
        return uniqueStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
