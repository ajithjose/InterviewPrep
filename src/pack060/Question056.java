package pack060;


/* Rat in a Maze Problem
 * ----------------------
 * 
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block 
 * i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. 
 * A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
 * In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination. 
 * Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can 
 * move in 4 directions and a more complex version can be with limited number of moves.
 * 
 */

public class Question056 {

	void solveMaze(int[][] maze){
		int[][] sol = new int[maze.length][maze.length];
		if(mazeUtil(maze, 0, 0, sol)){
			printSolution(sol);			
		}else{
			System.out.println("No solution found....");
		}
	}
	
	boolean mazeUtil(int[][] maze, int i, int j, int[][] sol) {

		if(i==(maze.length-1) && j==(maze.length-1)){
			sol[i][j] = 1;
			return true;
		}
		
		if(isSafe(i,j,maze)){
			sol[i][j] = 1;
			
			if(mazeUtil(maze, i+1, j, sol))
				return true;
			
			if(mazeUtil(maze, i, j+1, sol))
				return true;
			
			sol[i][j] = 0;	
		}
		
		return false;
	}

	boolean isSafe(int i, int j, int[][] maze) {

		if(i<maze.length && i>=0 && j<maze.length && j>=0 && maze[i][j]==1){
			return true;
		}
		return false;
	}

	void printSolution(int[][] sol) {
		for(int i=0;i<sol.length;i++){
			for(int j=0;j<sol.length;j++){
				System.out.print(" "+sol[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Question056 q = new Question056();
		int[][] maze = {{1, 0, 0, 1},
						{1, 1, 0, 1},
						{0, 1, 1, 1},
						{0, 1, 0, 1}};
		q.solveMaze(maze);
	}

}
