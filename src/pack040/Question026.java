package pack040;
// Counting Sort Algorithm
// Sorts input array in linear time provided the array contains elements in the range 0 to array length-1

//	For simplicity, consider the data in the range 0 to 9. 
//	Input data: 1, 4, 1, 2, 7, 5, 2
//	  1) Take a count array to store the count of each unique object.
//	  Index:     0  1  2  3  4  5  6  7  8  9
//	  Count:     0  2  2  0   1  1  0  1  0  0
//	
//	  2) Modify the count array such that each element at each index 
//	  stores the sum of previous counts. 
//	  Index:     0  1  2  3  4  5  6  7  8  9
//	  Count:     0  2  4  4  5  6  6  7  7  7
//	
//	The modified count array indicates the position of each object in 
//	the output sequence.
//	 
//	  3) Output each object from the input sequence followed by 
//	  decreasing its count by 1.
//	  Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
//	  Put data 1 at index 2 in output. Decrease count by 1 to place 
//	  next data 1 at an index 1 smaller than this index.

class Question026 { 
	
void countingSort(int[] A){
	int[] count = new int[A.length];
	int[] output = new int[A.length];
	
	// count[i] to contain no. of occurences of i
	for(int i=0; i<A.length; i++){
		count[A[i]]++;
	}
	
	// count[i] to contain no. of occurences <= i
	for(int i=1; i<A.length; i++){
		count[i] += count[i-1];
	}
	
	// output index for input array index i is count[A[i]]-1, count[A[i]] decremented
	for(int i=0; i<A.length; i++){
		output[count[A[i]]-1] = A[i];
		count[A[i]]--;
	}
	
	for(int i=0; i<A.length; i++){
		A[i] = output[i];
	}
}

public static void main(String[] args){
    Question026 q = new Question026();
    int[] A = {8,7,1,6,1,3,6,9,3,5};
    q.countingSort(A);
   	System.out.println("Sorted array is: ");
    for(int i:A)
    	System.out.print(i+" ");
}

}

// Time complexity - O(n)
// Space complexity - O(n)