package pack020;


class Question013 {

	int minLengthPalindromePartition(String str) {
		int n = str.length();
		char[] strChars = str.toCharArray();
		int[][] C = new int[n][n];
		boolean[][] P = new boolean[n][n];

		int L, i, j, k;
		for (i = 0; i < n; i++) {
			P[i][i] = true;
			C[i][i] = 0;
		}

		for (L = 2; L <= n; L++) {
			for (i = 0; i < n - L + 1; i++) {
				j = i + L - 1;
				if (L == 2) {
					P[i][j] = (strChars[i] == strChars[j]);
				} else {
					P[i][j] = (strChars[i] == strChars[j]) && P[i + 1][j - 1];
				}

				if (P[i][j] == true) {
					C[i][j] = 0;
				} else {
					C[i][j] = n;
					for (k = i; k < j; k++)
						C[i][j] = min(C[i][j], C[i][k] + C[k + 1][j] + 1);
				}
			}
		}

		return C[0][n - 1];
	}

	int min(int a, int b) {
		return (a < b ? a : b);
	}

	public static void main(String[] args) {
		Question013 q = new Question013();
		System.out.println("Minimum palindrome partitioning length is "
				+ q.minLengthPalindromePartition("ababbbabbababa"));
	}

}

// Time complexity O(n^3)