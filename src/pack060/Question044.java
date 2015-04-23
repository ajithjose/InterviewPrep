package pack060;
// Maximum difference between two elements

//	Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after 
//	the smaller number in arr[].
//	
//	Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). 
//	If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)

// Algorithm
//	Take the difference with the minimum element found so far. So we need to keep track of 2 things:
//	1) Maximum difference found so far (max_diff).
//	2) Minimum number visited so far (min_element).

class Question044 { 

int maxDiff(int[] A){

	int min_element = A[0];
	int max_diff = A[1]-A[0];

	for(int i=1;i<A.length;i++){
		int diff=A[i]-min_element;
		if( diff > max_diff){
			max_diff = diff;
		}
		if(A[i] < min_element){
			min_element = A[i];
		}		
	}
	
	return max_diff;
}

public static void main(String[] args){
    Question044 q = new Question044();
	int[] A = {2, 3, 10, 6, 4, 8, 1};
    System.out.println("Maximum difference is : "+q.maxDiff(A));
}

}

// Time complexity - O(n)
// Space complexity - O(1)