package pack040;
// Merge Sort Algorithm
// The input array is divided into two sub-arrays. Each sub-array is sorted. Then the sub-arrays are merged
// by the merge operation which compares each element from the two sub-arrays and picks the smaller one 
// incrementing the appropriate counters of the sub-array.


class Question025 { 

void mergeSort1(int[] A, int[] temp, int low, int high){
	if(low<high){
		int mid = low + (high-low)/2;
		mergeSort1(A, temp, low, mid);
		mergeSort1(A, temp, mid+1, high);
		merge2(A, temp, low, mid, high);
	}
}

void merge1(int[] A, int[] temp, int low, int mid, int high){
	int temp_pos = low;
	int left = low;
	int right = mid+1;
	int left_end = mid;
	int size = (high - low) + 1;
	while(left <= left_end && right <= high){
		if(A[left] <= A[right]){
			temp[temp_pos] = A[left++];
		}
		else{
			temp[temp_pos] = A[right++];
		}		
		temp_pos++;
	}
	while(left <= left_end){
		temp[temp_pos] = A[left++];
		temp_pos++;
	}
	while(right <= high){
		temp[temp_pos] = A[right++];
		temp_pos++;
	}
	
	for(int i=0;i<size;i++){
		A[high] = temp[high];
		high--;
	}
}

void merge2(int[] A, int[] temp, int low, int mid, int high){
	for(int i=low;i<=high;i++){
		temp[i] = A[i];
	}
	
	int left=low, right= mid+1;
	for(int j=low;j<=high;j++){
		if(left > mid) A[j] = temp[right++];
		else if(right > high) A[j] = temp[left++];
		else if(temp[right] < temp[left] ) A[j] = temp[right++];
		else A[j] = temp[left++];
	}
}

// optimized
void mergeSort2(int[] A, int[] temp, int low, int high){
	if(low<high){
		int mid = low + (high-low)/2;
		mergeSort2(A, temp, low, mid);
		mergeSort2(A, temp, mid+1, high);
		if(A[mid] <= A[mid+1]) return;
		merge2(A, temp, low, mid, high);
	}
}

// Bottom-up merge-sort -- without using recursion -- around 10 % slower
void mergeSort3(int[] A, int[] temp){
	for(int sz=1; sz<A.length; sz=sz+sz){
		for(int lo=0; lo<A.length-sz;lo+= sz+sz){
			merge2(A, temp, lo, lo+sz-1, Math.min(lo+sz+sz-1, A.length-1));
		}
	}
}

public static void main(String[] args){
    Question025 q = new Question025();
    int[] A = {8,6,10,7,9,30};
    int[] temp = new int[A.length];
    q.mergeSort2(A,temp,0,A.length-1);
    System.out.println("Sorted array is: ");
    for(int i : A){
    	System.out.print(i+" ");
    }
}

}

// Time complexity - O(nlogn)
// Space complexity - O(n) for the temp array