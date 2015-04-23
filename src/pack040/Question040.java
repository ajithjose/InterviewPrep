package pack040;
// Two elements whose sum is closest to zero

//	An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.
//	For the below array, program should print -80 and 85.

import java.util.Arrays;

class Question040 { 

Pair findElementsWithClosestZeroSum(int[] A){

	Arrays.sort(A);
	int left = 0;
	int right = A.length - 1;

	int sum = 0;
	int minSum = 10000;
	Pair selectedPair = null;
	
	while(left<right){
		sum = A[right] + A[left];
		
		if(Math.abs(sum) < minSum){
			minSum = Math.abs(sum);
			selectedPair = new Pair(A[left], A[right]);
		}	
		
		if(sum == 0){
			return selectedPair;
		}else if(sum < 0){			
			left++;	
		}else{
			right--;
		}
		
	}

	return selectedPair;
	
}

class Pair{
	int firstElement;
	int secondElement;

	public Pair(int f, int s){
		this.firstElement = f;
		this.secondElement = s;
	}

	public String toString(){
		return "("+this.firstElement+","+this.secondElement+")";
	}
}

public static void main(String[] args){
    Question040 q = new Question040();

	int[] A = {1, 60, -10, 70, -80, 85};;
    System.out.println("The pair with closest sum as zero is : "+q.findElementsWithClosestZeroSum(A));
}

}

// Time Complexity - O(n)
// Space Complexity - O(1)