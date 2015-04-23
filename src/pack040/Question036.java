package pack040;
// Leaders in an array
// -------------------
//	
//	Write a program to print all the LEADERS in the array. An element is leader 
//  if it is greater than all the elements to its right side. 
//	And the rightmost element is always a leader. 
//  For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
//	
//	Algorithm
//	----------
//	
//	Scan all the elements from right to left in array and keep track of maximum till now. 
//  When maximum changes it’s value, print it.

class Question036 { 

void printLeaders(int[] A){
	int max = A[A.length-1];
	System.out.print(max+" ");
	
	for(int i=A.length-2;i>=0;i--){
		if(A[i]>max){
			max=A[i];
			System.out.print(max+" ");
		}
	}
}

public static void main(String[] args){
    Question036 q = new Question036();
    int[] A = {16, 17, 4, 3, 5, 2};
    System.out.println("The leaders of the array A are ");
    q.printLeaders(A);
}

}

// Time complexity  - O(n)