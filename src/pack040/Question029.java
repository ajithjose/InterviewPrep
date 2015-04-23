package pack040;
// Given an array A[] and a number x, check for pair in A[] with sum as x

import java.util.Arrays;
import java.util.HashMap;

class Question029 { 
	
boolean findIfSumExistsBySorting(int[] A, int sum){
	
	Arrays.sort(A);
	
	int l = 0;
	int r = A.length-1;
	
	while(l<r){
		
		if(A[l] + A[r] > sum){
			r--;
		}else if(A[l] + A[r] < sum){
			l++;
		}else{
			return true;
		}
		
	}	

	return false;
}

// Time Complexity: O(nlogn) which would be the time complexity of the sorting algorithm
	
boolean findIfSumExists(int[] A, int sum){
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	for(int a : A){
		if(map.get(sum-a)==null){
			map.put(a, 1);
		}else{
			return true;
		}
	}
	return false;
}

public static void main(String[] args){
    Question029 q = new Question029();
    int[] A = {34, 6, 33, 3, 55, 63, 43, 1, 44, 66, 38};
    int sum = 50;
    if(q.findIfSumExists(A, sum)){
    	System.out.println("Aha, there is a sum");
    }else{
    	System.out.println("Nay.. no such pair");
    }
    
}

}

//	Time Complexity: O(n)
//	Auxiliary Space: O(R) where R is range of integers.