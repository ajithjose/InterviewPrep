package pack060;
// Segregate 0s and 1s in an array

//	You are given an array of 0s and 1s in random order. 
//	Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
//	
//	Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
//	Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 

class Question041 { 

void segregateZeroesAndOnes(int[] A){
	int left = 0;
	int right = A.length-1;

	while(left<right){
		while(A[left] == 0){
			left++;
		}

		while(A[right] == 1){
			right--;
		}

		if(left<right){
			swap(A, left, right);
		}
	}

}

void swap(int[] A, int left, int right){

	int temp = A[left];
	A[left] = A[right];
	A[right]= temp;

}

public static void main(String[] args){
    Question041 q = new Question041();

	int[] A = {0,1,1,1,1,0,0,0,1,1,0};

	q.segregateZeroesAndOnes(A);

	for(int a : A)
    	System.out.print(a+" ");
}

}

// Time Complexity - O(n)
// Space Complexity - O(1)

//	Same technique can be used to seggregate even and odd numbers given in a random order.