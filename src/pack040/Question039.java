package pack040;
// Count Inversions in an array

//	Inversion Count for an array indicates – how far (or close) the array is from being sorted. 
//	If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
//	Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
//	
//	Example:
//	The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

//	http://www.geeksforgeeks.org/counting-inversions/

//  Algorithm using enhanced merge sort
//  -------------------------------------
//	Suppose we know the number of inversions in the left half and right half of the array (let be inv1 and inv2), 
//	what kinds of inversions are not accounted for in Inv1 + Inv2? The answer is – the inversions we have to count during the merge step. 
//	Therefore, to get number of inversions, we need to add number of inversions in left subarray, right subarray and merge().
//	
//	How to get number of inversions in merge()?
//	In merge process, let i is used for indexing left sub-array and j for right sub-array. 
//	At any step in merge(), if a[i] is greater than a[j], then there are (mid – i) inversions. 
//	because left and right subarrays are sorted, so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) 
//  will be greater than a[j]

class Question039 { 

int mergeSort(int[] A, int[] temp, int left, int right){
	int mid, inversion_count=0;
	if(left<right){
		mid = left + (right-left)/2;
		
		inversion_count = mergeSort(A, temp, left, mid);
		inversion_count += mergeSort(A, temp, mid+1, right);

		inversion_count += merge(A, temp, left, mid+1, right);
	}

	return inversion_count;
}

int merge(int[] A, int[] temp, int left, int mid, int right){

	int low = left;
	int high = mid;
	int left_end = mid-1;
	int temp_pos = left;
	int inversion =0;

	while((low <= left_end) && (high <= right)){
		if(A[low]<=A[high]){
			temp[temp_pos] = A[low++];
		}else{
			temp[temp_pos] = A[high++];
			inversion += (mid-low);
		}
		temp_pos++;
	}

	while(low <= left_end){
		temp[temp_pos] = A[low++];
		temp_pos++;
	}
	
	while(high <= right){
		temp[temp_pos] = A[high++];
		temp_pos++;
	}

	for(int i=left;i<=right;i++){
		A[i] = temp[i];
	}

	return inversion;
}


public static void main(String[] args){
    Question039 q = new Question039();
	int A[] = {2, 4, 1, 3, 5};
	int temp[] = new int[A.length];
    System.out.println("The no. of inversions are : " + q.mergeSort(A, temp, 0, A.length-1));
}

}

// Time Complexity - O(nlogn)
// Space Complexity - O(n) - for using the temp array in merge sort