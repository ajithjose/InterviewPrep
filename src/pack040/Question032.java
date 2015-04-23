package pack040;
// Search an element in a sorted and pivoted array

//	An element in a sorted array can be found in O(log n) time via binary search. 
//	But suppose I rotate the sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
//	Devise a way to find an element in the rotated array in O(log n) time.
//	
//	Algorithm:
//	Find the pivot point, divide the array in two sub-arrays and call binary search.
//	The main idea for finding pivot is – for a sorted (in increasing order) and pivoted array, pivot element is the only only element for which next element to it is smaller than it.
//	Using above criteria and binary search methodology we can get pivot element in O(logn) time
//	
//	Input arr[] = {3, 4, 5, 1, 2}
//	Element to Search = 1
//	  1) Find out pivot point and divide the array in two 
//	      sub-arrays. (pivot = 2) /*Index of 5*/
//	  2) Now call binary search for one of the two sub-arrays.
//	      (a) If element is greater than 0th element then 
//	             search in left array
//	      (b) Else Search in right array 
//	          (1 will go in else as 1 < 0th element(3))
//	  3) If element is found in selected sub-array then return index 
//	     Else return -1.

class Question032 { 

int pivotedBinarySearch(int[] A, int num){
	
	int pivot = findPivot(A, 0, A.length-1);
	
	if(pivot == -1){
		return binarySearch(A, 0, A.length-1, num);
	}
	
	if(A[pivot] == num){
		return pivot;
	}
	if(num >= A[0]){
		return binarySearch(A, 0, pivot, num);	
	}else{
		return binarySearch(A, pivot+1, A.length-1, num);
	}
	
}

int findPivot(int[] A, int low, int high){
	
	// Base Cases
	if(high < low) return -1;
	if(high == low) return low;
	
	int mid = low+(high-low)/2;
	
	if(mid<high && A[mid] > A[mid+1]){
		return mid;
	}
	if(mid>low && A[mid] < A[mid-1]){
		return mid-1;
	}
	
	if(A[low]>=A[mid]){
		return findPivot(A, low, mid-1);
	}else{
		return findPivot(A, mid+1, high);
	}
}

int binarySearch(int[] A, int low, int high, int num){
	while(low<=high){
		int mid = low + (high-low)/2;
		
		if(num == A[mid]){
			return mid;
		}else if(num < A[mid]){
			high = mid-1;
		}else{
			low = mid+1;
		}
	}
	return -1;
}

public static void main(String[] args){
    Question032 q = new Question032();
    int[] A = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    int num  = 3;
    int numIndex = q.pivotedBinarySearch(A, num);
    if(numIndex == -1){
    	System.out.println("The element is not present in the array");
    }else{
    	System.out.println("The element "+num+" is at position " +numIndex);
    }
    
}

}

// Time Complexity - O(logn)
// Space complexity - O(1)

// The solution may not work for cases where the input array has duplicates.