package pack020;



class Question020 { 
	
int findOddOccurenceNumber(int[] numbers){
	int result = 0;
	for(int num : numbers){
		result = result^num;
	}
	return result;
	
}

public static void main(String[] args){
    Question020 q = new Question020();
    
    int[] test1 = {1, 2, 3, 2, 3, 1, 3};
    System.out.println("Test 1: " +q.findOddOccurenceNumber(test1));
    
    int[] test2 = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
    System.out.println("Test 2: " +q.findOddOccurenceNumber(test2));
}

}

// Time complexity - O(n)

// Output
// ------
// Test 1: 3
// Test 2: 5