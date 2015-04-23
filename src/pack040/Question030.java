package pack040;
// Heap Sort Algorithm

// The algorithm consists of the following steps:
// 1. Build a max-heap tree (each node greater than its children) from the input array.
// 2. Swap the root node to the last element in array.
// 3. Heapify the remaining binary tree.


class Question030 { 

// O(n) time complexity because it is done in a bottom-up manner
void buildHeap(double[] A){
	// Performing heapify in a bottom-up manner beginning with indices having children
	for(int i=(A.length-1)/2;i>=0;i--)
		max_heapify(A, i, A.length-1);
}

// O(logn) time complexity for each pass
void max_heapify(double[] A, int i, int heapSize){
	
	int leftChildIndex = 2*i;
	int rightChildIndex = 2*i+1;
	int maxIndex;

	if(leftChildIndex <= heapSize && A[leftChildIndex] > A[i]){
		maxIndex = leftChildIndex;
	}else{
		maxIndex = i;
	}
	
	if(rightChildIndex <= heapSize && A[rightChildIndex ] > A[maxIndex]){
		maxIndex = rightChildIndex ;
	}

	if(maxIndex != i){
		swap(A, i, maxIndex);
		max_heapify(A, maxIndex, heapSize);
	}
}

void swap(double[] A, int i, int j){
	double temp = A[i];
	A[i] = A[j];
	A[j] = temp;
}

void heapSort(double[] A){

int heapSize = A.length-1;

buildHeap(A);

for(int i=A.length-1;i>=0;i--){
	swap(A, i, 0);
	heapSize--;
	max_heapify(A, 0, heapSize);
}

}

public static void main(String[] args){
    Question030 q = new Question030();
    double[] A = {34, 6, 33, 3, 55, 63, 43, 1, 44, 66, 38};
    q.heapSort(A);
   	System.out.println("Sorted array is: ");
    for(double i:A)
    	System.out.print(i+" ");
}

}

// Time complexity - O(nlogn)
// Space complexity - O(1) i.e, in-place sorting algorithm

// The heap sort algorithm is however not stable and thats the reason it doesn't get used so often compared to quicksort/mergesort

//	A stable sort maintains the relative order of items that have the same key. For example, 
//	imagine your data set contains records with an employee id and a name. The initial order is:
//	
//	1, Jim
//	2, George
//	3, Jim
//	4, Sally
//	5, George
//	You want to sort by name. A stable sort will arrange the items in this order:
//	
//	2, George
//	5, George
//	1, Jim
//	3, Jim
//	4, Sally
//	Note that the duplicate records for "George" are in the same relative order 
//	as they were in the initial list. Same with the two "Jim" records.