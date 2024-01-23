package anoop.test.sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinAreaRect {
    public static void main(String[] args) {

        //System.out.println("Answer1: " + new MinAreaRect().minAreaRect(new int[][]{{1,1},{2,1},{3,2},{3,6},{2,3},{4,1},{2,6},{4,3},{4,5}}));
        System.out.println("Answer2: " + new MinAreaRect().minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}}));

    }
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            Set<Integer> ySet = map.getOrDefault(p[0], new HashSet());
            ySet.add(p[1]);
            map.put(p[0], ySet);
        }
        System.out.println(map);
        int min = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            System.out.println(p1[0]+","+p1[1]);
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) { // if have the same x or y
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) { // find other two points
                    System.out.println("    "+p2[0]+","+p2[1]);
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
