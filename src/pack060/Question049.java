package pack060;

//  Longest Common Subsequence Problem

// Given two sequences, find the length of longest subsequence present in both of them. 
// A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
// For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. 
// So a string of length n has 2^n different possible subsequences.

// It is a classic computer science problem, the basis of diff (a file comparison program that outputs 
// the differences between two files), and has applications in bioinformatics.

class Question049 {
	

	int lcsNaive(char[] S1, char[] S2, int m, int n) {
		if(m==0 || n==0){
			return 0;
		}else if(S1[m-1] == S2[n-1]){
			return 1 + lcs(S1, S2, m-1, n-1);
		}else{
			return max(lcs(S1, S2, m, n-1), lcs(S1, S2, m-1, n));
		}
	}
	
	static int[][] L;
	int lcs(char[] S1, char[] S2, int m, int n) {
		
		L = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					L[i][j] = 0;
				}else if(S1[i-1] == S2[j-1]){
					L[i][j] = 1 + L[i-1][j-1];
				}else{
					L[i][j] = max(L[i-1][j], L[i][j-1]);
				}
			}
		
		return L[m][n];
	}
	
	private int max(int x, int y) {
		return x>y ? x : y;
	}

	String printLCS(char[] S1, char[] S2, int m, int n){
		int lcsLength = lcs(S1, S2, m, n);
		char[] lcsChars = new char[lcsLength]; 
		
		int i=m, j=n, l=lcsLength-1;
		while(i>0 && j>0){
			if(S1[i-1] == S2[j-1]){
				lcsChars[l] = S1[i-1];
				i--;j--;l--;
			}else if( L[i-1][j] > L[i][j-1] ){
				i--;
			}else{
				j--;
			}
		}
		
		return new String(lcsChars);
	}
	
	public static void main (String[] args) 
    {
		Question049 q = new Question049();
		
		String S1 = "AGGTAB"; String S2 = "GXTXAYB";
		System.out.println("Length of LCS :: "+q.lcs(S1.toCharArray(), S2.toCharArray(), S1.length(), S2.length()));
		System.out.println("Longest Common Subsequence :: "+q.printLCS(S1.toCharArray(), S2.toCharArray(), S1.length(), S2.length()));
		
		
    }

}

// Time complexity - O(mn)
// Space complexity - O(mn)
