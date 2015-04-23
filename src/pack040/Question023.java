package pack040;
// Insertion Sort Algorithm

// Insertion sort is a simple and efficient stable sorting algorithm. In each iteration, insertion sort places an element 
// from the array to the correct position on the already sorted array elements.

class Question023 { 

void insertionSort(int[] A){
	int n = A.length;
	int j, v;
	for(int i=2;i<n;i++){
		v = A[i];
		j = i;
		while(j>0 && A[j-1]>v){
			A[j] = A[j-1];
			j--;
		}
		A[j] = v;
	}
	
}

public static void main(String[] args){
    Question023 q = new Question023();
    int[] A = {8,6,10,7,9,30};
    q.insertionSort(A);
    System.out.println("The sorted array is :");
    for(int a : A)
    	System.out.print(a + " ");
}

}

// Time complexity - O(n^2) worst case