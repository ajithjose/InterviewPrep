package pack060;
/*
 * Hamiltonian Cycle Problem
 * --------------------------
 * 
Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. 
A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in graph) from the last vertex to 
the first vertex of the Hamiltonian Path. Determine whether a given graph contains Hamiltonian Cycle or not. If it contains, then print the path. 
Following are the input and output of the required function.

Input:
A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph. 
A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.

Output:
An array path[V] that should contain the Hamiltonian Path. path[i] should represent the ith vertex in the Hamiltonian Path. 
The code should also return false if there is no Hamiltonian Cycle in the graph.

For example, a Hamiltonian Cycle in the following graph is {0, 1, 2, 4, 3, 0}. There are more Hamiltonian Cycles in the graph like {0, 3, 4, 2, 1, 0}

(0)--(1)--(2)
 |   / \   |
 |  /   \  | 
 | /     \ |
(3)-------(4)

And the following graph doesn’t contain any Hamiltonian Cycle.

(0)--(1)--(2)
 |   / \   |
 |  /   \  | 
 | /     \ |
(3)      (4)

 *
 */

public class Question058 {
	
	public static final int N = 5;

	void checkHamiltonianCycle(int[][] graph) {
		
		int[] path = new int[N];
		for(int p : path ){
			path[p] = -1;
		}
		
		/* Let us put vertex 0 as the first vertex in the path. If there is
	       a Hamiltonian Cycle, then the path can be started from any point
	       of the cycle as the graph is undirected */
		path[0] = 0;
		if(isHamiltonian(graph, path, 1)){
			printSolution(path);
		}else{
			System.out.println("No hamiltonian cycles found");
		}
		
	}
	
	private boolean isHamiltonian(int[][] graph, int[] path, int n) {

		/* base case: If all vertices are included in Hamiltonian Cycle */
		if(n == N){
			// And if there is an edge from the last included vertex to the
	        // first vertex
			if(graph[path[n-1]][0] == 1){
				return true;
			}
			return false;
		}
		
		for(int v=1; v<N; v++){
			/* Check if this vertex can be added to Hamiltonian Cycle */
			if(isSafe(graph, path, n, v)){
				path[n] = v;
				
				/* recur to construct rest of the path */
				if(isHamiltonian(graph, path, n+1)){
					return true;
				}
				
				/* If adding vertex v doesn't lead to a solution,
	               then remove it */				
				path[n] = -1;
			}
		}
		
		return false;
	}

	private boolean isSafe(int[][] graph, int[] path, int n, int v) {
		
		if(graph[path[n-1]][v] == 0)
			return false;
		
		for(int i=0; i<n; i++){
			if(path[i] == v)
				return false;
		}
		
		return true;
	}

	private void printSolution(int[] path) {
		for(int p : path){
			System.out.print(" "+p);
		}
		System.out.println(" "+path[0]);
	}

	public static void main(String[] args) {

		Question058 q = new Question058();
		/* Let us create the following graph
	      (0)--(1)--(2)
	       |   / \   |
	       |  /   \  |
	       | /     \ |
	      (3)-------(4)    */
		int[][] graph1 = {{0, 1, 0, 0, 1},
						 {1, 0, 1, 1, 1},
						 {0, 1, 0, 1, 0},
						 {0, 1, 1, 0, 1},
						 {1, 1, 0, 1, 0}};
		
		q.checkHamiltonianCycle(graph1);
		
		/* Let us create the following graph
	      (0)--(1)--(2)
	       |   / \   |
	       |  /   \  |
	       | /     \ |
	      (3)       (4)    */
		int[][] graph2 = {{0, 1, 0, 0, 1},
						 {1, 0, 1, 1, 1},
						 {0, 1, 0, 1, 0},
						 {0, 1, 1, 0, 0},
						 {1, 1, 0, 0, 0}};
		q.checkHamiltonianCycle(graph2);
	}

}

// Time complexity - O(N!)
