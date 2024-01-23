package anoop.test.sample;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] sorted = sort.sortArray(new int[]{1,3,5,10,2,4,8,6,7,21,1,3});
        for (int i : sorted){
            System.out.print(i + ",");
        }
    }

    public int[] sortArray(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }

        int pivot = nums.length/2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] ret = new int[right.length + left.length];
        int left_cur = 0, right_cur = 0, ret_cur = 0;
        while(left_cur < left.length && right_cur < right.length){
            if(left[left_cur] < right[right_cur]){
                ret[ret_cur] = left[left_cur];
                left_cur ++; ret_cur++;
            } else {
                ret[ret_cur] = right[right_cur];
                right_cur ++; ret_cur++;
            }
        }

        while(left_cur < left.length){
            ret[ret_cur] = left[left_cur];
            left_cur ++; ret_cur++;
        }

        while(right_cur < right.length){
            ret[ret_cur] = right[right_cur];
            right_cur ++; ret_cur++;
        }
        return ret;
    }
}
