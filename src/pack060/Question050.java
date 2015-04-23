package pack060;

//  Longest Common Substring Problem

// Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
// For example, if the given strings are “GeeksforGeeks” and “GeeksQuiz”, 
// the output should be 5 as longest common substring is “Geeks”

class Question050 {
	
	int lcSubStr(char[] S1, char[] S2, int m, int n) {
		
		int[][] L = new int[m+1][n+1];
		int maxLength = 0;
		
		for(int i=0;i<=m;i++)
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					L[i][j] = 0;
				}else if(S1[i-1] == S2[j-1]){
					L[i][j] = 1 + L[i-1][j-1];
					maxLength = max(L[i][j], maxLength);
				}else{
					L[i][j] = 0;
				}
			}
		
		return maxLength;
	}
	
	private int max(int x, int y) {
		return x>y ? x : y;
	}
	
	public static void main (String[] args) 
    {
		Question050 q = new Question050();
		
		String S1 = "AGGTAB"; String S2 = "GXTAB";
		System.out.println("Length of LCSubStr :: "+q.lcSubStr(S1.toCharArray(), S2.toCharArray(), S1.length(), S2.length()));
		
		
    }

}

// Time complexity - O(mn)
// Space complexity - O(mn)
