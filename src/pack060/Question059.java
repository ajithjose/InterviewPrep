package pack060;

/*
 * Sudoku Solver
 * -------------
 * 
 Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign digits (from 1 to 9) 
 to the empty cells so that every row, column, and subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9.
 
 Like all other Backtracking problems, we can solve Sudoku by one by one assigning numbers to empty cells. 
 Before assigning a number, we check whether it is safe to assign. We basically check that the same number is not present in current row, 
 current column and current 3X3 subgrid. After checking for safety, we assign the number, 
 and recursively check whether this assignment leads to a solution or not. 
 If the assignment doesn’t lead to a solution, then we try next number for current empty cell. 
 And if none of number (1 to 9) lead to solution, we return false.

  Find row, col of an unassigned cell
  If there is none, return true
  For digits from 1 to 9
    a) If there is no conflict for digit at row,col
        assign digit to row,col and recursively try fill in rest of grid
    b) If recursion successful, return true
    c) Else, remove digit and try another
  If all digits have been tried and nothing worked, return false
  
 * 
 */
public class Question059 {
	
	public static final int SUDOKU_SIZE = 9;
	public static final int UNASSIGNED = 0;
	
	static int grid_row = 0;
	static int grid_col = 0;

	/* Takes a partially filled-in grid and attempts to assign values to
	  all unassigned locations in such a way to meet the requirements
	  for Sudoku solution (non-duplication across rows, columns, and boxes) */
	private boolean solveSudoku(int[][] grid) {

		int row = 0;
		int col = 0;
		
		// If there is no unassigned location, we are done
		if(!findUnassigned(grid)){
			return true;
		}
		
		row = grid_row;
		col = grid_col;
		
		// consider digits 1 to 9
		for(int num=1; num<=9; num++){			
			
			// if looks promising
			if(isSafe(grid, row, col, num)){
				// make tentative assignment
				grid[row][col] = num;
				
				// return, if success, yay!
				if(solveSudoku(grid)){
					return true;
				}
				
				// failure, unmake & try again
				grid[row][col] = UNASSIGNED;
			}			
			
		}
		
		return false; // this triggers backtracking
	}
	
	/* Searches the grid to find an entry that is still unassigned. If
	   found, the static parameters grid_row, grid_col will be set and true is returned. 
	   If no unassigned entries remain, false is returned. */
	private boolean findUnassigned(int[][] grid) {
		for(int i=0; i<SUDOKU_SIZE; i++){
			for(int j=0; j<SUDOKU_SIZE; j++){
				if(grid[i][j] == UNASSIGNED){					
					grid_row = i; grid_col = j;
					return true;
				}
			}
		}
		return false;
	}

	/* Returns a boolean which indicates whether it will be legal to assign
	   num to the given row,col location. */
	private boolean isSafe(int[][] grid, int r, int c, int num) {
		
		if(!usedInRow(grid, r, num) &&
		   !usedInColumn(grid, c, num) &&
		   !usedInBox(grid, r-r%3, c-c%3, num)){
			return true;
		}
		
		return false;
	}

	/* Returns a boolean which indicates whether any assigned entry
	   within the specified 3x3 box matches the given number. */
	private boolean usedInBox(int[][] grid, int boxRowBegin, int boxColBegin, int num) {

		/* Check if 'num' is not already placed in current row,
	       current column and current 3x3 box */
		for(int r=0; r<3; r++){
			for(int c=0; c<3; c++){
				if(grid[boxRowBegin+r][boxColBegin+c] == num){
					return true;
				}
			}
		}
		return false;
	}

	/* Returns a boolean which indicates whether any assigned entry
	   in the specified row matches the given number. */
	private boolean usedInRow(int[][] grid, int r, int num) {
		for(int c=0;c<SUDOKU_SIZE;c++){
			if(grid[r][c] == num){
				return true;
			}
		}
		return false;
	}

	/* Returns a boolean which indicates whether any assigned entry
	   in the specified column matches the given number. */
	private boolean usedInColumn(int[][] grid, int c, int num) {
		for(int r=0;r<SUDOKU_SIZE;r++){
			if(grid[r][c] == num){
				return true;
			}
		}
		return false;
	}

	private void printSolution(int[][] grid) {
		for(int i=0; i<SUDOKU_SIZE;i++){
			for(int j=0;j<SUDOKU_SIZE;j++){
				System.out.print(" "+grid[i][j]);
			}
			System.out.println();
		}		
	}
	
	
	public static void main(String[] args) {
		Question059 q = new Question059();
		
		// 0 means unassigned cells
		int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
		                {5, 2, 0, 0, 0, 0, 0, 0, 0},
		                {0, 8, 7, 0, 0, 0, 0, 3, 1},
		                {0, 0, 3, 0, 1, 0, 0, 8, 0},
		                {9, 0, 0, 8, 6, 3, 0, 0, 5},
		                {0, 5, 0, 0, 9, 0, 6, 0, 0},
		                {1, 3, 0, 0, 0, 0, 2, 5, 0},
		                {0, 0, 0, 0, 0, 0, 0, 7, 4},
		                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		if(q.solveSudoku(grid)){
			q.printSolution(grid);
		}else{
			System.out.println("No solution available.");
		}

	}


}

// Time Complexity - O(n^m) where n is the number of possibilities for each square (i.e., 9 in classic Sudoku) 
// and m is the number of spaces that are blank.
// Space Complexity - O(n^2)