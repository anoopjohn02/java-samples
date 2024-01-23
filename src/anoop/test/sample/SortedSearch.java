package anoop.test.sample;

/**
 * Implement function countNumbers that accepts a sorted array of unique integers and, efficiently with respect to time used,
 * counts the number of array elements that are less than the parameter lessThan.
 *
 * For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        return recuMethod(sortedArray, lessThan, 0, sortedArray.length);
    }

    public static int recuMethod(int[] sortedArray, int lessThan, int low, int high){
        int middle = low  + ((high - low) / 2);
        if (high < low) {
            return -1;
        }

        if(middle >= sortedArray.length)
            return sortedArray.length;

        if(middle < 0)
            return 0;

        if(middle == 0) {
            if (sortedArray[middle] < lessThan)
                return 1;
            else
                return 0;
        }

        if(sortedArray[middle] > lessThan && sortedArray[middle-1] < lessThan)
            return middle;

        if (lessThan == sortedArray[middle]) {
            return middle;
        } else if (lessThan < sortedArray[middle]) {
            return recuMethod(sortedArray, lessThan, low, middle - 1);
        } else {
            return recuMethod(sortedArray, lessThan, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 3 }, 4));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3 }, 2));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbers(new int[] { 2, 3, 4, 5, 7, 10, 15, 19, 25 }, 1));
    }
}
