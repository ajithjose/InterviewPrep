package pack040;
// You are given a list of n-1 integers and these integers are in the range of 1 to n. 
// There are no duplicates in list. One of the integers is missing in the list. 
// Write an efficient code to find the missing integer.


class Question021 { 

// integer overflow case could occur in this method
int findMissingNumber1(int[] numbers){
	int result = (numbers[numbers.length-1]*(numbers[numbers.length-1]+1))/2;
	for(int num:numbers){
		result -= num;
	}
	return result;
}

// integer overflow is handled here
int findMissingNumber2(int[] numbers){
	
	int result1=0, result2=0;
	for(int i=1;i<=numbers[numbers.length-1];i++){
		result1 = result1^i;
	}
	
	for(int num : numbers ){
		result2 = result2^num;
	}
	
	return result1^result2;
	
}

public static void main(String[] args){
    Question021 q = new Question021();
    
    int a[] = {1, 2, 4, 5, 6};
    System.out.println("First Method: "+q.findMissingNumber1(a));
    System.out.println("Second Method: "+q.findMissingNumber2(a));
}

}

// Time complexity - O(n)

// Output
// -------
//
//	First Method: 3
//	Second Method: 3