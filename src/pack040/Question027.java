package pack040;
// Two sorted arrays, A and B are provided. First one is of size m+n, containing only m elements. 
// Second one of size n, containing n elements. Merge these two arrays into the first array so
// that the result is sorted.


class Question027 { 
	
void mergeFromLast(int[] A, int[] B){
	int left = A.length-B.length-1;
	int right = B.length-1;
	int ARightEnd = A.length-1;
	
	while(left>=0 && right>=0){
		if(A[left]>B[right]){
			A[ARightEnd] = A[left];
			left--;
		}else{
			A[ARightEnd] = B[right];
			right--;
		}
		ARightEnd--;
	}
	
	while(left>=0){
		A[ARightEnd] = A[left];
		left--;
		ARightEnd--;
	}
	
	while(right>=0){
		A[ARightEnd] = B[right];
		right--;
		ARightEnd--;
	}
}

public static void main(String[] args){
    Question027 q = new Question027();
    int[] A = new int[10];
    A[0] = 3; A[1] = 5; A[2] = 9; A[3] = 10;
    int[] B = {4,6,9,12,15,20};
    
    q.mergeFromLast(A,B);
    
    System.out.println("Sorted merged array is:");
    for(int i:A){
    	System.out.print(i + " ");
    }
}

}

// Time complexity - O(n)
// Space complexity - O(1)