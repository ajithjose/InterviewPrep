package pack060;

//  Given a cost matrix cost[][] and a position (m,n) in cost[][], write a function that returns cost of minimum cost path to
//	reach (m,n) from (0,0). Each cell of the matrix represents a cost to traverse through that cell.

// http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

class Question048 {
	
	int minCost(int[][] cost, int m, int n){
		
		int[][] table = new int[m+1][n+1];
		
		table[0][0] = cost[0][0];
		
		for(int i=1;i<=m;i++)
			table[i][0] = table[i-1][0] + cost[i][0];
		
		for(int j=1;j<=n;j++)
			table[0][j] = table[0][j-1] + cost[0][j];
		
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++)
				table[i][j] = min(table[i-1][j-1], table[i][j-1], table[i-1][j]) + cost[i][j];
		
		return table[m][n];
	}
	
	int minCost1(int[][] cost, int m, int n){
		
		if(m<0 || n<0){
			return Integer.MAX_VALUE;
		}
		
		if(m==0 && n==0){
			return cost[0][0];
		}
		
		return cost[m][n] + min(minCost(cost, m-1, n-1), minCost(cost, m, n-1), minCost(cost, m-1, n));
	}
	
	int min(int a, int b, int c){
		if(a<b){
			return a<c ? a : c;
		}else{
			return b<c ? b : c;			
		}
	}
	
	public static void main (String[] args) 
    {
		Question048 q = new Question048();
		int[][] cost ={{1,2,3},
					   {4,8,2},
					   {1,5,3}};
		System.out.println("Minimum cost is :: "+q.minCost1(cost, 2, 2));
		
    }
}

// Time complexity - O(mn)
// Space complexity - O(1)
