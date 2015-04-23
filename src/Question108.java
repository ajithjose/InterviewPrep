/*
 * Bitonic Search
 * ---------------
 * 
 * An array is bitonic if it is comprised of an increasing sequence of integers 
 * followed immediately by a decreasing sequence of integers. 
 * Write a program that, given a bitonic array of N distinct int values, 
 * determines whether a given integer is in the array. 
 * Your program should use ~ 3 lg N compares in the worst case.
 * 
 * Algorithm
 * ----------
 * 1. FInd the maximum of the numbers in O(log n) time 
 * 2. Binary search in first half in O(log n) time
 * 3. Binary search in second half in O(log n) time
 * 
 */

public class Question108 {

	void bitonicSearch(int[] A, int n) {
		
		int max = findMax(A);
		
		int searchIndex = binarySearch(A, n, 0, max);
		
		if(searchIndex == -1){
			searchIndex = binarySearch(A, n, max+1, A.length-1);
		}
		
		if(searchIndex == -1){
			System.out.println("Not found.");
		}else{
			System.out.println(" Item found at index : "+ searchIndex);
		}
	}
	
	int binarySearch(int[] A, int n, int l, int r) {
		
		int mid=0;
		while(l<=r){
			mid = l + (r-l)/2; 
			if(n == A[mid]){
				return mid;
			}else if(n<A[mid]){
				r = mid-1;
			}else{
				l = mid+1;
			}
		}
		return -1;
	}

	int findMax(int[] A) {
		
		int l = 0;
		int r = A.length - 1;
		
		int mid=0;
		
		while(l<r){			
			mid = l + (r-l)/2 ;
			if(A[mid] < A[mid+1]){
				l=mid+1; 			
			}else if(A[mid] > A[mid+1]){
				r=mid; 
			}
		}
		
		return mid;
	}

	public static void main(String[] args) {
		
		Question108 q = new Question108();
		
		int[] A = {2, 8, 10, 25, 52, 33, 21, 2};
		
		q.bitonicSearch(A, 25);

	}

}
