package pack060;

/*
 * 
 * Print all possible combinations of r elements in a given array of size n
 * --------------------------------------------------------------------------
 
Given an array of size n, generate and print all possible combinations of r elements in array. 
For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
 
Algorithm
----------

One by one consider every element of input array, and recur for two cases:

1) The element is included in current combination (We put the element in data[] and increment next available index in data[])
2) The element is excluded in current combination (We do not put the element and do not change index)

When number of elements in data[] become equal to r (size of a combination), we print it.

 */

import java.util.Arrays;

public class Question060 {
	
	void combinationsUtil(int[] arr, int r){
		int[] data = new int[r];
		
		Arrays.sort(arr);
		combinations(arr, arr.length, r, 0, 0, data);
	}
	
	void combinations(int[] arr, int n, int r, int i, int index, int[] data){
		
		// Current combination is ready, print it
		if(index==r){
			for(int j=0;j<data.length;j++){
				System.out.print(data[j]);
			}
			System.out.println();
			return;
		}
		
		// When no more elements are there to put in data[]
		if(i>=n)
			return;
		
		data[index] = arr[i];
		
		// For handling duplicates
		while(i<n-1 && arr[i] == arr[i+1]){
			i++;
		}
		
		// current is included, put next at next location
		combinations(arr, n, r, i+1, index+1, data);
		
		// current is excluded, replace it with next (Note that
	    // i+1 is passed, but index is not changed)
		combinations(arr, n, r, i+1, index, data);		
	}
	
	
	public static void main(String[] args) {
		
		Question060 q = new Question060();		
		System.out.println("Test Case 1");
		System.out.println("-----------");
		int[] arr1 = {1, 2, 3, 4, 5};		
		q.combinationsUtil(arr1, 3);	
		System.out.println("-----------");
		System.out.println();
		
		System.out.println("Test Case 2");
		System.out.println("-----------");
		int[] arr2 = {3, 2, 3, 4, 5};		
		q.combinationsUtil(arr2, 3);
		System.out.println("-----------");
		
	}

}

// Time Complexity - O(n^r)
