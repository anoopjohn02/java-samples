package anoop.test.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectricPos {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("*A40-D2");
        inputs.add("*A30-D3...D5");
        inputs.add("*S01-C11,-C12");

        Map<String, String> map = createMap(inputs);
        for (String key: map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }

    private static Map<String, String> createMap(List<String> inputs){
        Map<String, String> map = new HashMap<>();

        for (String input: inputs) {
            if(isNumberRange(input)){
                addNumberRange(map, input);
            } else if(isListing(input)){
                addList(map, input);
            } else {
                map.put(input, input);
            }
        }
        return map;
    }

    private static boolean isNumberRange(String input){
        if(input.contains("...")){
            return true;
        }
        return false;
    }

    private static void addNumberRange(Map<String, String> map, String input){
        String[] list = input.split("\\.\\.\\.");
        String firstItem = list[0];
        map.put(firstItem, input);
        String prefix = firstItem.substring(0, firstItem.indexOf("-"));
        int start = Integer.parseInt(firstItem.substring(firstItem.indexOf("-") + 2)) + 1;

        String lastItem = list[1];
        int end = Integer.parseInt(lastItem.substring(1));
        String var = String.valueOf(lastItem.charAt(0));

        while(start <= end){
            map.put(prefix + "-" + var + start, input);
            start++;
        }
    }

    private static boolean isListing(String input){
        if(input.contains(",-")){
            return true;
        }
        return false;
    }

    private static void addList(Map<String, String> map, String input){
        String[] list = input.split(",");
        String firstItem = list[0];
        String prefix = firstItem.substring(0, firstItem.indexOf("-"));
        map.put(firstItem, input);
        for(int start = 1; start < list.length; start++){
            map.put(prefix + list[start], input);
        }
    }
}
