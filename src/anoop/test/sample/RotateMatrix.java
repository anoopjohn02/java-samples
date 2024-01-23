package anoop.test.sample;

public class RotateMatrix {

    // You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    // Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    public static void main(String[] args) {


    }
    public void rotate(int[][] matrix) {
        int size = matrix[0].length;

        for(int i=0, j=size-1; i<j; i++, j--){
            int[] row = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = row;
        }

        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){
                if( i != j){
                    int val = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = val;
                }
            }
        }
    }
}
