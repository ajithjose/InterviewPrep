package pack060;
/*
 * N Queens Problem
 * -----------------
 * 
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. 
 * 
 * The idea is to place queens one by one in different columns, starting from the leftmost column.
 * When we place a queen in a column, we check for clashes with already placed queens. 
 * In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution. 
 * If we do not find such a row due to clashes then we backtrack and return false.
 * 
 */
public class Question055 {
	
	private static final int N = 8;
	
	/* This function solves the N Queen problem using Backtracking.
    It returns false if queens cannot be placed,
	otherwise return true and prints placement of queens in the form of 1s. Please
	note that there may be more than one solutions, this function prints one of the
	feasible solutions.*/
	void solveNQ(){
		int[][] qMatrix = new int[N][N];
		
		if(!NQUtil(qMatrix,0)){
			System.out.println("N Queens can't arranged on the board...");
		}else{
			printNQueens(qMatrix);
		}
	}
	
	/* A recursive utility function to solve N Queen problem */
	boolean NQUtil(int[][] qMatrix, int c) {
		
		/* base case: If all queens are placed then return true */
		if(c>=N){
			return true;
		}
		
		/* Consider this column and try placing this queen in all rows
	       one by one */
		for(int r=0;r<N;r++){
			/* Check if queen can be placed on board[r][c] */
			if(isSafe(qMatrix,r,c)){
				/* Place this queen in board[i][col] */
				qMatrix[r][c] = 1;
				
				/* recur to place rest of the queens */
				if(NQUtil(qMatrix, c+1)){
					return true;
				}
				
				/* If placing queen in board[i][col] doesn't lead to a solution
	               then remove queen from board[i][col] */
				qMatrix[r][c] = 0;				
			}
		}
		
		 /* If queen can not be place in any row in this colum col
        then return false */
		return false; // backtracking
	}
	
	/* A utility function to check if a queen can be placed on board[row][col]
	   Note that this function is called when "c" queens are already placed
	   in columns from 0 to c-1. So we need to check only left side for
	   attacking queens */
	boolean isSafe(int[][] qMatrix, int r, int c) {
		
		 /* Check this row on left side */
		for(int i=0;i<c;i++){
			if(qMatrix[r][i] == 1){
				return false;
			}
		}
		
		/* Check upper diagonal on left side */
		for(int i=r,j=c;i>=0 && j>=0;i--,j--){
			if(qMatrix[i][j] == 1){
				return false;
			}
		}
		
		/* Check lower diagonal on left side */
		for(int i=r,j=c;j>=0 && i<N;i++,j--){
			if(qMatrix[i][j] == 1){
				return false;
			}
		}
		
		return true;
	}

	void printNQueens(int[][] qMatrix) {
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(" "+qMatrix[i][j]);
			}
			System.out.println();
		}		
	}

	public static void main(String[] args) {
		
		Question055 q = new Question055();
		q.solveNQ();
				
	}

}

// Time complexity - O(n^2) n is the no. of rows / columns
// Space complexity - O(n^2)
