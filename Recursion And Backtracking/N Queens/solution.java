import java.io.*;
import java.util.*;

public class solution{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        int n = scn.nextInt(); 
        int[][] cb = new int[n][n];
        printNQueens(cb, "", 0);
    }

    public static void printNQueens(int[][] cb, String qsf, int row) {
        if(row == cb.length){
            System.out.println(qsf + ".");
            return;
        }

        for(int col = 0; col < cb.length; col++){

            if(IsQueenSafe(cb, row, col) == true){
                cb[row][col] = 1;
                printNQueens(cb, qsf + row + "-" + col + ", ", row + 1);
                cb[row][col] = 0; 
            }
        }
    }

    public static boolean IsQueenSafe(int[][] cb, int row, int col){
        // col 
        for(int i = row - 1; i >= 0; i--){
            if(cb[i][col] == 1){
                return false; 
            }
        }

        // left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(cb[i][j] == 1){
                return false; 
            }
        }
        
        // right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < cb[0].length; i--, j++){
            if(cb[i][j] == 1){
                return false; 
            }
        }
        
        return true;
    }
}