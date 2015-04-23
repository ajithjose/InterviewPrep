/*
 * 
Quick Select Algorithm
-----------------------

Given an array of N items, find a kth smallest item. 
 
An approach similar to quick-sort can be used to solve this problem.

 */

public class Question151 {

	public static void main(String[] args) {
		int[] A = {20, 2, 8, 31, 5, 9, 92, 28, 12};
		
		int kthSmallest = quickSelect(A, 5);
		
		System.out.println("The 5th smallest item in the array is "+kthSmallest);

	}

	private static int quickSelect(int[] A, int k) {
		
		int lo = 0, hi = A.length-1;
		int p = 0;
		k--;
		while(lo<hi){
			p = partition(A, lo, hi);
			if(p<k) lo = p+1;
			else if(p>k) hi = p-1;
			else return A[k];
		}
		return A[k];
	}

	private static int partition(int[] A, int lo, int hi) {
		
		int left = lo, right = hi+1;
		
		while(true){
			while(A[++left] < A[lo]){
				if(left == hi) break;
			}
			while(A[lo] < A[--right]){
				if(right == lo) break;
			}
			if(left>=right) break;
			swap(A, left, right);
		}
		
		swap(A, lo, right);
		return right;
	}

	private static void swap(int[] A, int i, int j) {		
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}	

}

// Time complexity - worst case same as quick sort - O(n^2)
// On average - O(n)