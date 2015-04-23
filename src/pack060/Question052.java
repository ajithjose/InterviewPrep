package pack060;

// KMP Pattern Searching Algorithm

/*
 Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.

Examples:
1) Input:

  txt[] =  "THIS IS A TEST TEXT"
  pat[] = "TEST"
Output:

Pattern found at index 10
2) Input:

  txt[] =  "AABAACAADAABAAABAA"
  pat[] = "AABA"
Output:

   Pattern found at index 0
   Pattern found at index 9
   Pattern found at index 13
   
   KMP (Knuth Morris Pratt) Pattern Searching
   -------------------------------------------
   
The Naive pattern searching algorithm doesn’t work well in cases where we see many matching characters followed by a mismatching character. 
Following are some examples.

   txt[] = "AAAAAAAAAAAAAAAAAB"
   pat[] = "AAAAB"

   txt[] = "ABABABCABABABCABABABC"
   pat[] =  "ABABAC" (not a worst case, but a bad case for Naive)
   
The KMP matching algorithm uses degenerating property (pattern having same sub-patterns appearing more than once in the pattern) of the pattern 
and improves the worst case complexity to O(n). The basic idea behind KMP’s algorithm is: whenever we detect a mismatch (after some matches), 
we already know some of the characters in the text (since they matched the pattern characters prior to the mismatch). We take advantage of 
this information to avoid matching the characters that we know will anyway match.

KMP algorithm does some preprocessing over the pattern pat[] and constructs an auxiliary array lps[] of size m (same as size of pattern). 
Here name lps indicates longest proper prefix which is also suffix.. 
For each sub-pattern pat[0…i] where i = 0 to m-1, lps[i] stores length of the maximum matching proper prefix which is also a suffix of the sub-pattern pat[0..i].

   lps[i] = the longest proper prefix of pat[0..i] 
              which is also a suffix of pat[0..i]. 
Examples:
For the pattern “AABAACAABAA”, lps[] is [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]
For the pattern “ABCDE”, lps[] is [0, 0, 0, 0, 0]
For the pattern “AAAAA”, lps[] is [0, 1, 2, 3, 4]
For the pattern “AAABAAA”, lps[] is [0, 1, 2, 0, 1, 2, 3]
For the pattern “AAACAAAAAC”, lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]

Searching Algorithm
--------------------
Unlike the Naive algo where we slide the pattern by one, we use a value from lps[] to decide the next sliding position. 
Let us see how we do that. When we compare pat[j] with txt[i] and see a mismatch, we know that characters pat[0..j-1] match with txt[i-j+1...i-1], 
and we also know that lps[j-1] characters of pat[0...j-1] are both proper prefix and suffix which means we do not need to match these lps[j-1] characters with txt[i-j...i-1] 
because we know that these characters will anyway match. See KMPSearch() in the below code for details.

Preprocessing Algorithm
------------------------
In the preprocessing part, we calculate values in lps[]. To do that, we keep track of the length of 
the longest prefix suffix value (we use len variable for this purpose) for the previous index. 
We initialize lps[0] and len as 0. If pat[len] and pat[i] match, we increment len by 1 and assign the incremented value to lps[i]. 
If pat[i] and pat[len] do not match and len is not 0, we update len to lps[len-1]. See computeLPSArray () in the below code for details.

 */

class Question052 {
	
	void naiveSearch(char[] pat, char[] txt){
		int n = txt.length;
		int m = pat.length;
		
		for(int i=0; i<n-m+1; i++){		
			int j;
			for(j=0; j<m; j++){
				if(txt[i+j] != pat[j]){
					break;
				}
			}	
			if(j == m){
				System.out.println("Pattern found at text index "+i);
			}			
		}
		
	}
	
	void kmpSearch(char[] pat, char[] txt){
		int n = txt.length;
		int m = pat.length;
		
		int[] lps = computeLPSArray(pat);
		
		int i=0, j=0;
		while(i<n){
			if(txt[i]==pat[j]){
				i++;
				j++;
			}
			
			if(j==m){
				System.out.println("Pattern found at text index "+(i-j));
				j=lps[j-1];
			}
			
			// mismatch after j matches
			else if(i<n && txt[i]!=pat[j]){
				// Do not match lps[0..lps[j-1]] characters,
		        // they will match anyway
				if(j!=0){
					j=lps[j-1];
				}else{
					i++;
				}
			}
		}
	}
	
	int[] computeLPSArray(char[] pat) {
		
		int m = pat.length;
		int[] lps = new int[m];
		
		lps[0] = 0;
		int i = 1;
		int len = 0; // length of the previous longest prefix suffix
		
		// the loop calculates lps[i] for i = 1 to m-1
		while(i<m){
			
			if(pat[i] == pat[len]){
				len++;
				lps[i] = len;
				i++;
			}
			
			else{
				if( len!=0 ){
					// This is tricky. Consider the example AAACAAAA and i = 7.
					len = lps[len-1];
					// Also, note that we do not increment i here
				}else{
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static void main (String[] args) 
    {
		Question052 q = new Question052();
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
//		q.naiveSearch(pat.toCharArray(), txt.toCharArray());
		q.kmpSearch(pat.toCharArray(), txt.toCharArray());
    }

	// Time complexity - O(n) 
	// Space complexity - O(m+n)
}

