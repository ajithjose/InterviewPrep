/*
 * Print all increasing sequences of length k from first n natural numbers
 * -----------------------------------------------------------------------
 * 
 Given two positive integers n and k, print all increasing sequences of length k 
 such that the elements in every sequence are from first n natural numbers.

Examples:

Input: k = 2, n = 3
Output: 1 2
        1 3
        2 3 

Input: k = 5, n = 5
Output: 1 2 3 4 5

Input: k = 3, n = 5
Output: 1 2 3
        1 2 4
        1 2 5
        1 3 4
        1 3 5
        1 4 5
        2 3 4
        2 3 5
        2 4 5
        3 4 5

It’s a good recursion question. The idea is to create an array of length k. 
The array stores current sequence. For every position in array, we check the previous element and one by one 
put all elements greater than the previous element. If there is no previous element (first position), 
we put all numbers from 1 to n.
 */

public class Question062 {


	void printIncreasingSequences(int n, int k) {
		
		int[] data = new int[k];
		
		increasingSequenceUtil(n, k, 0, data);
		
	}
	
	void increasingSequenceUtil(int n, int k, int len, int[] data) {
		
		// If length of current increasing sequence becomes k,
	    // print it
		if(len==k){
			for(int d:data){
				System.out.print(d);
			}
			System.out.println();
			return;
		}
		
		// Decide the starting number to put at current position:
	    // If length is 0, then there are no previous elements
	    // in arr[].  So start putting new numbers with 1.
	    // If length is not 0, then start from value of
	    // previous element plus 1.
		int i=(len==0 ? 1 : data[len-1]+1);
		
		// Increase length
		len++;
		
		// Put all numbers (which are greater than the previous
	    // element) at new position.
		while(i<=n){
			data[len-1] = i;
			increasingSequenceUtil(n, k, len, data);
			i++;
		}
		
		// This is important. The variable 'len' is shared among
	    // all function calls in recursion tree. Its value must be
	    // brought back before next iteration of while loop
		len--;
	}

	public static void main(String[] args) {
		Question062 q = new Question062();
		q.printIncreasingSequences(5, 3);

	}


}

// Time complexity - O((n-k)^k)  // Doubtful
