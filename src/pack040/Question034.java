package pack040;
// Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.

//  Reversal Algorithm
//  ------------------
//	Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is:
//	Reverse A to get ArB. /* Ar is reverse of A */
//	Reverse B to get ArBr. /* Br is reverse of B */
//	Reverse all to get (ArBr) r = BA.
//	
//	For arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
//	A = [1, 2] and B = [3, 4, 5, 6, 7]
//	Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
//	Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
//	Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]


class Question034 { 
	
void rotate(int[] A, int d){
	if(d>A.length){
		System.out.println("Please provide appropriate rotation index");
	}
	reverseArray(A, 0, d-1);
	reverseArray(A, d, A.length-1);
	reverseArray(A, 0, A.length-1);
}

void reverseArray(int[] A, int low, int high){
	int temp;
	while(low<high){
		temp = A[low];
		A[low] = A[high];
		A[high] = temp;
		low++;
		high--;
	}
}

public static void main(String[] args){
    Question034 q = new Question034();
    int[] A = {1,2,3,4,5,6,7,8,9};
    q.rotate(A, 3);
    System.out.println("The rotated array is : ");
    for(int a : A)
    	System.out.print(a + " ");
}

}

// Time complexity - O(n)
// Space complexity - O(1)