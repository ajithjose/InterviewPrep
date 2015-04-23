package pack060;

//  Longest Increasing Substring (LIS) Problem

// The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence 
// of a given sequence such that all elements of the subsequence are sorted in increasing order. 
// For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.

class Question051 {
	
	int lis(int[] S, int n) {
		
		int[] L = new int[n];
		int max = 0;
		for(int i=0;i<n;i++){
			L[i] = 1;
		}
		
		for(int i=1;i<n;i++)
			for(int j=0;j<i;j++){
				if(S[i] > S[j] && L[i] <= L[j]){
					L[i] = L[j]+1;
					if(L[i]>max){
						max = L[i];
					}
				}
			}
		return max;
	}
	
	public static void main (String[] args) 
    {
		Question051 q = new Question051();
//		int[] seq = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int[] seq = new int[]{1, 7, 2, 12, 5, 15};
		System.out.println("Longest Increasing Subsequence Length :: "+q.lis(seq, seq.length));	
    }

}

// Time complexity - O(n^2) -- there is a nlogn solution to this problem
// Space complexity - O(n)
