package pack040;
// Maximum sum such that no two elements are adjacent

//	Question: Given an array of positive numbers, find the maximum sum of a subsequence with the 
//	constraint that no 2 numbers in the sequence should be adjacent in the array. 
//	So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
//	
//	Algorithm:
//	----------
//	Loop for all elements in arr[] and maintain two sums incl and excl where incl = Max sum including the previous element 
//	and excl = Max sum excluding the previous element.
//	
//	Max sum excluding the current element will be max(incl, excl) and max sum 
//	including the current element will be excl + current element 
//	(Note that only excl is considered because elements cannot be adjacent).
//	
//	At the end of the loop return max of incl and excl.
		
class Question035 { 

int findMaximumNonAdjacentSum(int[] A){
	int incl = A[0];
	int excl = 0;
	int excl_new;
	
	for(int i=1;i<A.length;i++){
		excl_new = max(incl, excl);
		incl = excl + A[i];
		excl = excl_new;
	}
	
	return max(incl, excl);
}

int max(int excl, int incl){
	return (incl>excl ? incl : excl);
}

public static void main(String[] args){
    Question035 q = new Question035();
    int[] A = {5,  5, 10, 40, 50, 35}; 
    System.out.println("The maximum sum without adjacent elements is : "+ q.findMaximumNonAdjacentSum(A));
}

}

// Time complexity  - O(n)