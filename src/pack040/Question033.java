package pack040;
// Write a program to reverse an array


class Question033 { 

void reverseArrayIterative(int[] A, int low, int high){
	int temp;
	while(low<high){
		temp = A[low];
		A[low] = A[high];
		A[high] = temp;
		low++;
		high--;
	}	
}

void reverseArrayRecursive(int[] A, int low, int high){
	if(low>=high) return;
	int temp;
	temp = A[low];
	A[low] = A[high];
	A[high] = temp;
	reverseArrayRecursive(A, low+1, high-1);
}

public static void main(String[] args){
    Question033 q = new Question033();
    int[] A = {1,2,3,4,5,6,7};
    int[] B = {10,20,30,40,50,60,70,80};
    
    q.reverseArrayIterative(A,0,A.length-1);
    q.reverseArrayRecursive(B,0,B.length-1);
    
    System.out.println("The reverse of array A is: ");
    for(int a:A)
    	System.out.print(a+ " ");
    
    System.out.println();	
    System.out.println("The reverse of array B is: ");
    for(int b:B)
    	System.out.print(b+ " ");
}

}

// Time complexity - O(n)
// Space complexity - O(1)