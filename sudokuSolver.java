package Sudoku;
import java.util.*;
public class sudokuSolver {
    public static void display(int[][] board){
    for(int i=0;i<board.length;i++) {
        for (int j = 0; j < board.length; j++) {
            if(j==3 || j==6){
                System.out.print(" | ");
            }
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
        if(i==2 || i==5 )
            System.out.println("----------------------");
    }
    }
    public static void solve(int[][] board,int i,int j){
        if(i==board.length){
            display(board);
            return;
        }

        int ni = 0;
        int nj = 0;

    if(j == board[0].length-1){
        ni = i+1;
        nj=0;
    }
    else {
        ni = i;
        nj = j+1;
    }

    if(board[i][j] !=0)
        solve(board,ni,nj);
    else{
        for(int po = 1;po<=9;po++){ // po represents possible values
            if(isValid(board, i, j, po)){
                board[i][j] = po;
                solve(board,ni,nj);
                board[i][j] = 0;
            }
        }
    }

    }
    public static boolean isValid(int[][] board,int x, int y,int val){


        for(int j=0;j<board[0].length;j++){ // checking rows
            if(board[x][j] == val)
                return false;
        }
        for(int i=0;i< board.length;i++){ // checking cols
            if(board[i][y] == val)
                return false;
        }
        //submatrix top left row/3,col/3
        int submatr_i = x/3 * 3;
        int submatr_j = y/3 *3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                if(board[submatr_i + i][submatr_j + j] == val)
                    return false;
        }
        return true;
    }
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int[][]arr = new int[9][9];
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                arr[i][j] = sc.nextInt();

        solve(arr,0,0);
    }
}

//3 0 6 5 0 8 4 0 0
//5 2 0 0 0 0 0 0 0
//0 8 7 0 0 0 0 3 1
//0 0 3 0 1 0 0 8 0
//9 0 0 8 6 3 0 0 5
//0 5 0 0 9 0 6 0 0
//1 3 0 0 0 0 2 5 0
//0 0 0 0 0 0 0 7 4
//0 0 5 2 0 6 3 0 0



