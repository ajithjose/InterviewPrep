package pack060;
// Union and Intersection of two sorted arrays

// Using merge step of merge sort algorithm

class Question043 { 

void union(int[] A, int[] B){

	int left=0, right=0;
	int aHigh = A.length - 1;
	int bHigh = B.length - 1;

	while((left <= aHigh) && (right <= bHigh)){		
		if(A[left]<B[right]){
			System.out.print(A[left++]+" ");
			System.out.print(B[right++]+" ");
		}
		else if(B[right]<A[left]){
			System.out.print(B[right++]+" ");
			System.out.print(A[left++]+" ");
		}
		else{
			System.out.print(A[left++]+" ");right++;
		}
	}
}

void intersection(int[] A, int[] B){

	int left=0, right=0;
	int aHigh = A.length - 1;
	int bHigh = B.length - 1;

	while((left <= aHigh) && (right <= bHigh)){		
		if(A[left]<B[right]){
			left++;right++;
		}
		else if(B[right]<A[left]){
			left++;right++;
		}
		else{
			System.out.print(A[left++]+" ");right++;
		}
	}
}

public static void main(String[] args){
    Question043 q = new Question043();

	int[] A= {1, 4, 23, 26, 31, 40};
	int[] B= {2, 4, 20, 26, 32, 40};

    System.out.println("Union of A & B is :");
	q.union(A, B);
	System.out.println();
    System.out.println("Intersection of A & B is :");
	q.intersection(A, B);

}

}

// Time Complexity - O(m+n)
// Space Complexity - O(1)