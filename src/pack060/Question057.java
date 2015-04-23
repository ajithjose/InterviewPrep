package pack060;

/*
 
 Graph Coloring Problem
 -----------------------
 
Given an undirected graph and a number m, determine if the graph can be colored with at most m colors 
such that no two adjacent vertices of the graph are colored with same color. 
Here coloring of a graph means assignment of colors to all vertices.

Input:
1) A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] 
is adjacency matrix representation of the graph. A value graph[i][j] is 1 
if there is a direct edge from i to j, otherwise graph[i][j] is 0.
2) An integer m which is maximum number of colors that can be used.

Output:
An array color[V] that should have numbers from 1 to m. color[i] should represent 
the color assigned to the ith vertex. The code should also return false 
if the graph cannot be colored with m colors.

Backtracking Algorithm
------------------------

The idea is to assign colors one by one to different vertices, starting from the vertex 0. 
Before assigning a color, we check for safety by considering already assigned colors to the adjacent vertices. 
If we find a color assignment which is safe, we mark the color assignment as part of solution. 
If we do not a find color due to clashes then we backtrack and return false.

 */

public class Question057 {
	
	// Number of vertices in the graph
	public static final int N = 4;

	/* This function solves the m Coloring problem using Backtracking.
	  It mainly uses graphUtil() to solve the problem. Please note that there
	  may be more than one solutions, this function prints one of the
	  feasible solutions.*/
	void solveGraphColors(int[][] graph, int m) {
		
		int[] color = new int[N];
		
		// Call graphUtil() for vertex 0
		if(graphUtil(graph, color, m, 0)){
			printSolution(color);
		}else{
			System.out.println("Solution does not exist...");
		}
		
	}

	boolean graphUtil(int[][] graph, int[] color, int m, int v) {
		
		/* base case: If all vertices are assigned a color then
	       return true */
		if(v == N){
			return true;
		}
		
		/* Consider this vertex v and try different colors */
		for(int c=1;c<=m;c++){			
			
			/* Check if assignment of color c to v is fine*/
			if(isSafe(graph, color, c, v)){
				color[v] = c;
				
				/* recur to assign colors to rest of the vertices */
				if(graphUtil(graph, color, m, v+1))
					return true;
				
				/* If assigning color c doesn't lead to a solution
	               then remove it */
				color[v] = 0;
			}
		}		
		
		/* If no color can be assigned to this vertex then return false */
		return false;
	}
	
	/* A utility function to check if the current color assignment
	   is safe for vertex v */
	boolean isSafe(int[][] graph, int[] color, int c, int v) {
		
		for(int i=0;i<N;i++){
			if(graph[v][i] == 1 && c == color[i]) // this is tricky
				return false;
		}
		return true;
	}

	void printSolution(int[] sol) {
		for(int j=0;j<sol.length;j++){
			System.out.print(" "+sol[j]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Question057 q = new Question057();
		/* Create following graph and test whether it is 3 colorable
	      (3)---(2)
	       |   / |
	       |  /  |
	       | /   |
	      (0)---(1)
	    */
		int[][] graph = {{0, 1, 1, 1},
						 {1, 0, 1, 0},
						 {1, 1, 0, 1},
						 {1, 0, 1, 0}};
		
		int m = 3; // Number of colors
		q.solveGraphColors(graph, m);

	}


}
