package anoop.test.sample;

import java.util.HashSet;
import java.util.Set;

public class NQueens {

    /*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

    Given an integer n, return the number of distinct solutions to the n-queens puzzle

    Input: n = 4
    Output: 2
    Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

    Input: n = 1
    Output: 1
     */

    public static void main(String[] args) {
        System.out.println(new NQueens().totalNQueens(4));
        System.out.println(new NQueens().totalNQueens(1));
    }

    public int totalNQueens(int n) {
        return place(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int place(int n, int row, Set<Integer> cols, Set<Integer> diagonal, Set<Integer> antiDiagonal){
        if(row == n){
            return 1;
        }

        int solutions = 0;

        for(int col = 0; col < n; col++){
            int diag = row - col;
            int antiDiag = row + col;

            if(diagonal.contains(diag) || antiDiagonal.contains(antiDiag) || cols.contains(col)){
                continue;
            }

            cols.add(col);
            diagonal.add(diag);
            antiDiagonal.add(antiDiag);

            solutions = solutions + place(n, row+1, cols, diagonal, antiDiagonal);

            cols.remove(col);
            diagonal.remove(diag);
            antiDiagonal.remove(antiDiag);
        }

        return solutions;
    }
}
