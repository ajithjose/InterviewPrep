
/*
 * 
 Breadth First Search in an Undirected Graph
 --------------------------------------------
 
 Algorithm (BFS from source vertex s)
 ------------------------------------
 
 1. Put s onto a FIFO queue, and mark s as visited. 
 2. Repeat until the queue is empty:  
 	- remove the least recently added vertex v  
 	- add each of v's unvisited neighbors to the queue, and mark them as visited. 
 * 
 */
public class Question156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BreadthFirstPaths{
	boolean[] visited;
	int[] edgeTo;
	int startingVertex;
	
	public BreadthFirstPaths(Graph G, int s){
		visited = new boolean[G.V.length];
		edgeTo = new int[G.V.length];
		startingVertex = s;
		
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		
		visited[s] = true;
		
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		
		while(!q.isEmpty()){
			int v = q.dequeue();
			for(int w : G.adj(v)){
				if(!visited[w]){
					q.enqueue(w);
					visited[w] = true;
					edgeTo[w] = v;
				}
			}
		}
		
	}
	
	public boolean hasPathTo(int v){
		return visited[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != startingVertex; x = edgeTo[x])
			path.push(x);
		path.push(startingVertex);
		return  path;
	}
}