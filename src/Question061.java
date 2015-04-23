/*
 * Print all possible strings of length k that can be formed from a set of n characters
 * -------------------------------------------------------------------------------------

Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.

Examples:

Input: 
set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb


Input: 
set[] = {'a', 'b', 'c', 'd'}, k = 1
Output:
a
b
c
d
For a given set of size n, there will be n^k possible strings of length k. 
The idea is to start from an empty output string (we call it prefix in following code). 
One by one add all characters to prefix. 

For every character added, print all possible strings with current prefix by recursively calling for k equals to k-1.
 */

public class Question061 {
	
	private void printAllKLengthStrings(char[] chars, int k) {
		int n = chars.length;		
		kLengthStringUtil(chars, "", n, k);
	}
	
	private void kLengthStringUtil(char[] chars, String prefix, int n, int k) {
		
		if(k==0){
			System.out.println(prefix);
			return;
		}
		
		for(int i=0;i<n;i++){
			String newPrefix = prefix + chars[i];
			
			kLengthStringUtil(chars, newPrefix, n, k-1);
		}
		
	}

	public static void main(String[] args){
		
		Question061 q = new Question061();
		
		char[] str = {'a', 'b'};
		q.printAllKLengthStrings(str, 3);
	}

}

// Time Complexity - O(n^k)
