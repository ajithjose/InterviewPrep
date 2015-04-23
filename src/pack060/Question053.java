package pack060;
import java.util.HashMap;


/*
 *  Anagram Substring Search (Search for all permutations of substring)
 *  -------------------------------------------------------------------
 *  
 Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] and its permutations (or anagrams) in txt[]. You may assume that n > m. 
Expected time complexity is O(n)

Examples:

1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
   Output:   Found at Index 0
             Found at Index 5
             Found at Index 6
2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
   Output:   Found at Index 0
             Found at Index 1
             Found at Index 4
 
 We can achieve O(n) time complexity under the assumption that alphabet size is fixed which is typically true as we have maximum 256 possible characters in ASCII. The idea is to use two count arrays:

1) The first count array store frequencies of characters in pattern.
2) The second count array stores frequencies of characters in current window of text.

The important thing to note is, time complexity to compare two count arrays is O(1) as the number of elements in them are fixed (independent of pattern and text sizes). Following are steps of this algorithm.
1) Store counts of frequencies of pattern in first count array countP[]. Also store counts of frequencies of characters in first window of text in array countTW[].

2) Now run a loop from i = M to N-1. Do following in loop.
…..a) If the two count arrays are identical, we found an occurrence.
…..b) Increment count of current character of text in countTW[]
…..c) Decrement count of first character in previous window in countWT[]

3) The last window is not checked by above loop, so explicitly check it.

 */

public class Question053 {
	
	void anagramSearch(char[] pat, char[] txt){
		int N = txt.length;
		int M = pat.length;
		
		HashMap<Character, Integer> patMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> txtMap = new HashMap<Character, Integer>();
		for(int i=0;i<M;i++){
			int pCount = (patMap.get(pat[i]) != null) ? (patMap.get(pat[i])  + 1) : 1;
			patMap.put(pat[i], pCount);
			
			int tCount = (txtMap.get(txt[i]) != null) ? (txtMap.get(txt[i])  + 1) : 1;
			txtMap.put(txt[i], tCount);
		}
		
		// Traverse through remaining characters of pattern
		for(int i=M;i<N;i++){
			
			// Compare counts of current window of text with
	        // counts of pattern[]
			if(match(patMap, txtMap)){
				System.out.println("Anagram match found at index "+(i-M));
			}
			
			// Remove the first character of previous window
			txtMap.put(txt[i-M], (txtMap.get(txt[i-M]) - 1));			
			if(txtMap.get(txt[i-M]) == 0){
				txtMap.remove(txt[i-M]);
			}
			
			// Add current character to current window
			int tCount = (txtMap.get(txt[i]) != null) ? (txtMap.get(txt[i])  + 1) : 1;
			txtMap.put(txt[i], tCount);
		}
		
		if(match(patMap, txtMap)){
			System.out.println("Anagram match found at index "+(N-M));
		}
		
	}

	private boolean match(HashMap<Character, Integer> patMap, HashMap<Character, Integer> txtMap) {
		
		if(patMap.size() != txtMap.size()){
			return false;
		}
		
		for(Character c : patMap.keySet()){
			if(patMap.get(c) != txtMap.get(c))
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		Question053 q = new Question053();
		String txt = "BACDGABCDA";
		String pat = "ABCD";
		
		q.anagramSearch(pat.toCharArray(), txt.toCharArray());		

	}

}

// Time complexity - O(n) where n is either M or N-M, whichever is greater
// Space complexity - O(n)