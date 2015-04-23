import java.util.HashMap;

/*
 * 
 
 Minimum String Moves (Difficult Problem)
 ---------------------
 
 We have two strings A and B which are permutations of the same set of characters. 
 We need to change these strings to obtain two identical strings by performing  the following operations:
 - swap two consecutive characters of a string
 - swap the first and the last characters of a string

The operation can be performed on either string.
What is the minimum number of moves that we need in order to obtain two equal strings?
 
Input Format
Two lines of input, with string A on the first and string B on the second. 
 
Constraints
1 < length(A) = length(B) <= 2,000
All the input characters are between 'a' and 'z'
The count of each distinct character in A is identical to the count of the same character in B.
 
Output Format:
Print the minimum number of moves on a separate line of output
 
Sample input:
aab
baa

Sample output:
1
 
Explanation:
For example, swapping the first and last character of string aab converts it to baa, so both strings are now equal.

-----------------------

This is a NP hard problem. 
Tried to do this in O(n log n) time using a modified mergesort. But it doesn't give desired output at times.

Thought behind this: 

Mismatches in the two strings can actually be thought of as array inversions (elements out of order in an ordered sequence) 

let s1 = kamal 
let s2 = amalk 

If we assume that s1 is the "correct" ordering, we can create an array P that holds a mapping from a character in s2 to its position in s1.


# correct ordering
0 1  2 3 4
k a m a l

# ordering of s2
1  2 3 4 0
a m a  l k

So, P = [1, 2, 3, 4, 0]
We can see the inversions of P by drawing intersection lines between the elements of P and the correct ordering:

0       ------  1
1----/ ------  2
2----/ ------  3 
3----/ ------  4
4----/          ok
0

(assume a line between 0 and 0, ascii art is not the best medium)
Counting the number of intersections will tell use the number of elements "out of order", noting that "out of order" in this case means distance of s2 from s1 in swaps. 

To implement inversion counting, you can modify the merge_sort and merge steps of the standard merge_sort algorithm:

------------------------------------------
 */

public class Question203 {
	
	int minimumStringMoves(String A, String B){
		char[] aChars = A.toCharArray();
		char[] bChars = B.toCharArray();
		
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int i=0; i<aChars.length; i++){
			charMap.put(aChars[i], i);
		}
		
		int[] indexArr = new int[aChars.length];
		for(int i=0; i<bChars.length; i++){
			indexArr[i] = charMap.get(bChars[i]);
		}
		
		return mergeSort(indexArr, 0, indexArr.length-1);
	}

	private int mergeSort(int[] A, int start, int end) {
		if(start<end){
			int mid = start + (end-start)/2;
			int x = mergeSort(A, 0, mid);
			int y = mergeSort(A, mid+1, end);
			int z = merge(A, start, mid, end);
			
			return x+y+z;
		}
		
		return 0;
	}

	private int merge(int[] A, int start, int mid, int end) {
		int l = start;
		int r = mid+1;
		int[] temp = new int[end-start+1];
		int i = 0;
		int inversionCount = 0;
		
		while(l<=mid && r<=end){
			if(A[l]<=A[r]){
				temp[i++] = A[l++];
			}else{
				inversionCount += mid-l+1;
				temp[i++] = A[r++];
			}
		}
		
		while(l<=mid){
			temp[i++] = A[l++];
		}
		
		while(r<=end){
			temp[i++] = A[r++];
		}
		
		for(int j=0;j<temp.length;j++){
			A[j+start] = temp[j];
		}
		
		return inversionCount;
	}

	public static void main(String[] args) {
		Question203 q = new Question203();
		
		int minMoves = q.minimumStringMoves("abcd", "dbca");
		
		System.out.println(minMoves);

	}

}
