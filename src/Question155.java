import java.util.ArrayList;
import java.util.List;

/*
 * 
Depth First Search in an Undirected Graph
------------------------------------------

Algorithm (DFS to visit a vertex v)
---------
1. Mark v as visited. 
2. Recursively visit all unmarked vertices w adjacent to v. 

 * 
 */
public class Question155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Graph{
	
	int[] V;
	List<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int[] V){
		this.V = V;
		
		adj = new List[V.length];
		for(int v : V){
			adj[v] = new ArrayList<Integer>();
		}		
	}
	
	void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
}

class DepthFirstPaths{
	boolean[] visited;
	int[] edgeTo;
	int startingVertex;
	
	public DepthFirstPaths(Graph G, int s){
		visited = new boolean[G.V.length];
		edgeTo = new int[G.V.length];
		startingVertex = s;
		
		dfs(G, s);
	}

	private void dfs(Graph G, int s) {
		
		visited[s] = true;
		
		for(int v : G.adj(s)){
			if(!visited[v]){
				dfs(G, v);
				edgeTo[v] = s;
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