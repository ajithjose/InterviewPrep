package pack060;
//	Floor and Ceiling in a sorted array
//	Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.
//	
//	For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
//	For x = 0:    floor doesn't exist in array,  ceil  = 1
//	For x = 1:    floor  = 1,  ceil  = 1
//	For x = 5:    floor  = 2,  ceil  = 8
//	For x = 20:   floor  = 19,  ceil doesn't exist in array

//	Algorithm Used - Binary Search

class Question045 { 

int ceilSearch(int[] A, int low, int high, int x){
	if(x<=A[low]){
		return low;
	}
	if(x>A[high]){
		return -1;
	}

	int mid = low + (high-low)/2;
	
	if(x==A[mid]){
		return mid;
	}else if(x<A[mid]){
		if(mid-1>=low && x>A[mid-1]){
			return mid;
		}else{		
			return ceilSearch(A, low, mid-1, x);
		}
	}else{
		if(mid+1<=high && x<A[mid+1]){
			return mid+1;
		}else{
			return ceilSearch(A, mid+1, high, x);
		}
	}
}

public static void main(String[] args){
    Question045 q = new Question045();
	int[] A ={1, 2, 8, 10, 10, 12, 19};
	int x = 13;
	int ceil = q.ceilSearch(A, 0, A.length-1, x);
	if(ceil == -1){
		System.out.println("Ceiling does not exist");
	}else{
    	System.out.println("Ceiling of x :: "+ A[ceil]);
	}
}

}

// Time complexity - O(logn)
// Space complexity - O(1)