package pack060;

/*
 * Knight's Tour Problem
 * ----------------------
 * The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each square exactly once.
 * 
 * We can use a backtracking algorithm to solve the problem. Backtracking works in an incremental way to attack problems. 
 * Typically, we start from an empty solution vector and one by one add items (Meaning of item varies from problem to problem. 
 * In context of Knight’s tour problem, an item is a Knight’s move). When we add an item, we check if adding the current item 
 * violates the problem constraint, if it does then we remove the item and try other alternatives. If none of the alternatives 
 * work out then we go to previous stage and remove the item added in the previous stage. If we reach the initial stage back then 
 * we say that no solution exists. If adding an item doesn’t violate constraints then we recursively add items one by one. 
 * If the solution vector becomes complete then we print the solution.
 * 
 */

public class Question054 {
	
	public static final int N = 8;

	/* This function solves the Knight Tour problem using Backtracking.  This
	function mainly uses ktUtil() to solve the problem and prints the tour.
	Please note that there may be more than one solutions, this function
	prints one of the feasible solutions.  */
	void solveKnightsTour() {
		int[][] tourMatrix = new int[N][N];
		
		// Since the Knight is initially at the first block
		tourMatrix[0][0] = 1;
		
		/* moveX[] and moveY[] define next move of Knight.
	       moveX[] is for next value of x coordinate
	       moveY[] is for next value of y coordinate */
		int[] moveX = {-1, -1, -2, -2, 1,  1, 2,  2};
		int[] moveY = {-2,  2, -1,  1, 2, -2, 1, -1};
		
		/* Start from 0,0 and explore all tours using solveKTUtil() */
		if(!ktUtil(0, 0, 2, tourMatrix, moveX, moveY)){
			System.out.println("No Knight's Tour Path found..");
		}else{
			printKnightsTour(tourMatrix);
		}
	}
	
	/* A recursive utility function to solve Knight Tour problem */
	boolean ktUtil(int x, int y, int k, int[][] tourMatrix,	int[] moveX, int[] moveY) {
		
		if(k == (N*N + 1)){
			return true;
		}
		
		/* Try all next moves from the current coordinate x, y */
		for(int i=0; i<8; i++){			

			int mx = x+moveX[i];
			int my = y+moveY[i];
			
			if(isSafe(tourMatrix, mx, my)){
				tourMatrix[mx][my] = k;
				if(ktUtil(mx, my, k+1, tourMatrix, moveX, moveY)){
					return true;
				}
				tourMatrix[mx][my] = 0;
			}
		}
		return false; // backtracking
	}

	/* A utility function to check if i,j are valid indexes for N*N chessboard */
	boolean isSafe(int[][] tourMatrix, int mx, int my) {
		if((mx>=0 && mx<N) && (my>=0 && my<N) && tourMatrix[mx][my] == 0)
			return true;
		return false;
	}

	/* A utility function to print solution matrix sol[N][N] */
	void printKnightsTour(int[][] tourMatrix) {
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.printf(" %2d ",tourMatrix[i][j]);
			}
			System.out.println();
		}		
	}

	public static void main(String[] args) {
		Question054 q = new Question054();
		q.solveKnightsTour();
	}

}

// Time complexity 
// ----------------
// Since at each step you have 8 possibilities to check and this has to be done for each cell (minus the last one) 
// the time complexity of this algorithm is O(8^(n^2-1)) = O(8^(n^2)) where n is the number of squares on the edges of the checkboard.
// Space complexity - O(n^2)