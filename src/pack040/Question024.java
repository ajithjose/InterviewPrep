package pack040;
// Quick Sort Algorithm
// A pivot element is selected and the array is partitioned into two sub-arrays. All elements of the first sub-array is 
// lesser than the pivot element whereas all elements of the second sub-array is greater than the pivot element

//	When does the worst case of Quicksort occur?
//	The answer depends on strategy for choosing pivot. In the versions of Quick Sort where leftmost (or rightmost) element 
//  is chosen as pivot, the worst occurs in following cases.
//	
//	1) Array is already sorted in same order.
//	2) Array is already sorted in reverse order.
//	3) All elements are same (special case of case 1 and 2)
//
//	Since these cases are very common use cases, the problem was easily solved by choosing either a random index for the pivot, 
//	choosing the middle index of the partition or (especially for longer partitions) choosing the median of the first, 
//	middle and last element of the partition for the pivot. With these modifications, the worst case of Quick sort 
//	has less chances to occur, but worst case can still occur if the input array is such that the maximum (or minimum) 
//	element is always chosen as pivot.

class Question024 { 
	
void quickSort(int[] A, int low, int high){
	if(low < high){
		int pivot = partition(A, low, high);
		quickSort(A, low, pivot-1);
		quickSort(A, pivot+1, high);
	}
}

int partitionShort(int[] A, int low, int high) {
	
	int pivot = low;
	for(int i=low+1;i<=high;i++){
		if(A[i] < A[low]){
			swap(A, i, ++pivot);
		}
	}
	swap(A, low, pivot);
	return pivot;
}

int partitionLong(int[] A, int low, int high){
	int pivot_item = A[low];
	int left = low;
	int right = high;
	
	while(left<right){
		while(A[left] <= pivot_item){
			left++;
		}
		while(A[right] > pivot_item){
			right--;
		}
		if(left<right){
			swap(A,left,right);
		}
	}
	
	A[low] = A[right];
	A[right] = pivot_item;
	return right;
}

int partition(int[] A, int low, int high){
	
	int left = low, right = high+1;
	
	while(true){
		while(A[++left] < A[low])
			if(left==high) break;
		while(A[low] < A[--right])
			if(right==low) break;
		
		if(left>=right) break;
		swap(A, left, right);
	}
	
	swap(A, low, right);
	return right;
}

void swap(int A[], int left, int right){
	int temp = A[left];
	A[left] = A[right];
	A[right] = temp;
}

public static void main(String[] args){
    Question024 q = new Question024 ();
    int[] A = {8,6,10,7,9,30};
    q.quickSort(A, 0, A.length-1);
    System.out.println("The sorted array is :");
    for(int a : A)
    	System.out.print(a + " ");
}

}

// Average case time complexity - O(nlogn)
// Worst case time complexity - O(n^2)
// Worst case space complexity - O(1)
