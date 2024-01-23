package anoop.test.sample;

import java.util.HashMap;
import java.util.Map;

public class Permutations {

    public static void main(String[] args) {
        Permutations p = new Permutations();
        System.out.println("Solution : "+p.isPermutations(new int[]{3,1,3,2,4,1,6}, new int[]{1,2,3,4,3,6,1}));
    }

    public boolean isPermutations(int[] arr1, int[] arr2){
        if(arr1 == null
                || arr2 == null
                || arr1.length == 0
                || arr1.length != arr2.length){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int n:arr1){
            int count = map.getOrDefault(n,0);
            map.put(n,count+1);
        }

        for(int n:arr2){
            if(!map.containsKey(n) || map.get(n)==0){
                return false;
            }
            int count = map.get(n);
            count--;
            map.put(n,count);
        }

        return true;
    }

}
