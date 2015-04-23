package pack040;
// Return majority element if it exists

//	 A majority element in an array A[] of size n 
//	 is an element that appears more than n/2 times (and hence there is at most one such element).
//	
//	 Moore’s Voting Algorithm
//   -------------------------
//	
//	 This is a two step process.
//	 1. Get an element occurring most of the time in the array. This phase will make sure that if there is a majority element then it will return that only.
//	 2. Check if the element obtained from above step is majority element.
//	
//	 1. Finding a Candidate:
//	 The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm. Basic idea of the algorithm is if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.
//	
//	 findCandidate(a[], size)
//	 1.  Initialize index and count of majority element
//	      maj_index = 0, count = 1
//	 2.  Loop for i = 1 to size – 1
//	     (a)If a[maj_index] == a[i]
//	         count++
//	     (b)Else
//	         count--;
//	     (c)If count == 0
//	         maj_index = i;
//	         count = 1
//	 3.  Return a[maj_index]
//	 Above algorithm loops through each element and maintains a count of a[maj_index], If next element is same then increments the count, if next element is not same then decrements the count, and if the count reaches 0 then changes the maj_index to the current element and sets count to 1.
//	 First Phase algorithm gives us a candidate element. In second phase we need to check if the candidate is really a majority element. Second phase is simple and can be easily done in O(n). We just need to check if count of the candidate element is greater than n/2.
//	
//	 Example:
//	 A[] = 2, 2, 3, 5, 2, 2, 6
//	 Initialize:
//	 maj_index = 0, count = 1 –> candidate ‘2?
//	 2, 2, 3, 5, 2, 2, 6
//	
//	 Same as a[maj_index] => count = 2
//	 2, 2, 3, 5, 2, 2, 6
//	
//	 Different from a[maj_index] => count = 1
//	 2, 2, 3, 5, 2, 2, 6
//	
//	 Different from a[maj_index] => count = 0
//	 Since count = 0, change candidate for majority element to 5 => maj_index = 3, count = 1
//	 2, 2, 3, 5, 2, 2, 6
//	
//	 Different from a[maj_index] => count = 0
//	 Since count = 0, change candidate for majority element to 2 => maj_index = 4
//	 2, 2, 3, 5, 2, 2, 6
//	
//	 Same as a[maj_index] => count = 2
//	 2, 2, 3, 5, 2, 2, 6
//	
//	 Different from a[maj_index] => count = 1
//	
//	 Finally candidate for majority element is 2.
//	
//	 First step uses Moore’s Voting Algorithm to get a candidate for majority element.
//	
//	 2. Check if the element obtained in step 1 is majority
//	
//	 printMajority (a[], size)
//	 1.  Find the candidate for majority
//	 2.  If candidate is majority. i.e., appears more than n/2 times.
//	        Print the candidate
//	 3.  Else
//	        Print "NONE"
        
class Question031 { 

int findCandidate(int A[]){
	int majorityElement = A[0];
	int count = 1;
	
	for(int i=1;i<A.length;i++){
		if(A[i] == majorityElement){
			count++;
		}else if(count==0){
			majorityElement = A[i];
		}else{
			count--;
		}
	}
	return majorityElement;
}

void findMajorityElement(int A[]){
	int candidate = findCandidate(A);
	int candidateCount = 0;
	for(int a : A){
		if(candidate == a){
			candidateCount++;
		}
	}
	if(candidateCount > A.length/2){
		System.out.println("The majority element is "+candidate);
	}else{
		System.out.println("No majority element present");
	}
	
}

public static void main(String[] args){
    Question031 q = new Question031();
    int[] A = {1,2,2,2,3,3,2};
    q.findMajorityElement(A);
}

}

// Time complexity - O(n)
// Space complexity - O(1)