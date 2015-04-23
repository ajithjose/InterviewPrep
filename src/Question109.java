/*
 * 
 * Egg Dropping Puzzle
 * --------------------
 * 
 The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.

Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, 
and which will cause the eggs to break on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. 
Drop the egg from the first-floor window; if it survives, drop it from the second floor window. 
Continue upward until it breaks. In the worst case, this method may require 36 droppings. 
Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be 
dropped so that total number of trials are minimized.

In this post, we will discuss solution to a general problem with n eggs and k floors. 
The solution is to try dropping an egg from every floor (from 1 to k) and 
recursively calculate the minimum number of droppings needed in worst case. 
The floor which gives the minimum value in worst case is going to be part of the solution.
In the following solutions, we return the minimum number of trails in worst case; 
these solutions can be easily modified to print floor numbers of every trials also.

Optimal Substructure:
----------------------
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor, 
   then we only need to check for floors lower than x with remaining eggs; 
   so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, 
   then we only need to check for floors higher than x; 
   so the problem reduces to k-x floors and n eggs.

Since we need to minimize the number of trials in worst case, we take the maximum of two cases. 
We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.

  k ==> Number of floors
  n ==> Number of Eggs
  eggDrop(n, k) ==> Minimum number of trails needed to find the critical
                    floor in worst case.
  eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)): 
                 x in {1, 2, ..., k}}
 * 
 */
		
public class Question109 {
	@SuppressWarnings("unused")
	private int eggDrop(int n, int k) {
		
		if(k==1 || k==0){
			return k;
		}
		
		if(n==1){
			return k;
		}
		
		int min = Integer.MAX_VALUE, res;
		for(int x=1;x<=k;x++){
			res = max(eggDrop(n-1, x-1), eggDrop(n, k-x));
			
			if(res<min){
				min = res;
			}			
		}
		return min+1;
	}
	
/*
 * 
 Overlapping Subproblems
 ------------------------
 
 It should be noted that the above function computes the same subproblems again and again. 
 See the following partial recursion tree, E(2, 2) is being evaluated twice. 
 There will many repeated subproblems when you draw the complete recursion tree even for small values of n and k.


                         E(2,4)
                           |                      
          ------------------------------------- 
          |             |           |         |   
          |             |           |         |       
      x=1/\          x=2/\      x=3/ \    x=4/ \
        /  \           /  \       ....      ....
       /    \         /    \
 E(1,0)  E(2,3)     E(1,1)  E(2,2)
          /\  /\...         /  \
      x=1/  \               .....
        /    \
     E(1,0)  E(2,2)
            /   \
            ......

Partial recursion tree for 2 eggs and 4 floors.
Since same suproblems are called again, this problem has Overlapping Subprolems property. 
So Egg Dropping Puzzle has both properties (see this and this) of a dynamic programming problem. 
Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems 
can be avoided by constructing a temporary array grid[][] in bottom up manner.
 * 	
 */
	private int eggDropDynamic(int n, int k) {
		
		int[][] grid = new int[n+1][k+1];
		
		int res;
		
		for(int i=0;i<=n;i++){
			grid[i][0]=0;
			grid[i][1]=1;
		}
		
		for(int i=0;i<=k;i++){
			grid[1][i]=i;
		}
		
		for(int i=2;i<=n;i++){
			for(int j=2;j<=k;j++){
				grid[i][j] = Integer.MAX_VALUE;
				for(int x=1;x<=j;x++){
					res = 1 + max(grid[i-1][x-1], grid[i][j-x]);
					if(res < grid[i][j]){
						grid[i][j] = res;
					}
				}
			}
		}
		
		return grid[n][k];
	}
	
	private int max(int m, int n) {
		return (m>n) ? m : n;
	}

	public static void main(String[] args) {
		
		Question109 q = new Question109();
		
		int n = 2, k = 36;
		System.out.println("Minimum number of trials in worst case with "+n+" eggs and "+k+" floors :: "+q.eggDropDynamic(n,k));

	}

}

// Time Complexity: O(nk^2)
// Auxiliary Space: O(nk)

/* Problem with similar description
 * --------------------------------
 * 
 Throwing eggs from a building. Suppose that you have an N-story building and plenty of eggs. 
 Suppose also that an egg is broken if it is thrown off floor F or higher, and unbroken otherwise. 
 First, devise a strategy to determine the value of F such that the number of broken eggs is ~ lg N when using ~ lg N throws, 
 then find a way to reduce the cost to ~ 2 lg F when N is much larger than F.
 Hint: binary search; repeated doubling and binary search.
 */